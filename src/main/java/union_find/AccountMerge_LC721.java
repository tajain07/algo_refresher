package union_find;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;


public class AccountMerge_LC721 {

    class UnionFind {
        int[] sz;
        int[] id;
        int size;

        public UnionFind(int size) {
            this.size = size;
            sz = new int[size];
            id = new int[size];

            for (int i = 0; i < size; i++) {
                sz[i] = 1;
                id[i] = i;
            }
        }


        public int find(int x) {
            if (x == id[x])
                return x;

            return id[x] = find(id[x]);
        }

        public void union(int x, int y) {
            final int xset = find(x);
            final int yset = find(y);

            if (xset == yset)
                return;

            if (sz[xset] >= sz[yset]) {
                sz[xset] += sz[yset];
                sz[yset] = 0;
                id[yset] = xset;
            } else {
                sz[yset] += sz[xset];
                sz[xset] = 0;
                id[xset] = yset;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accountList) {
        final int accountSize = accountList.size();
        AccountMerge_LC721.UnionFind dsu = new UnionFind(accountSize);
        Map<String, Integer> emailToAccountIdMap = new HashMap<>();

        for (int i = 0; i < accountSize; i++) {
            final String accountName = accountList.get(i).get(0);
            for (int j = 1; j < accountList.get(i).size(); j++) {
                final String email = accountList.get(i).get(j);
                if (!emailToAccountIdMap.containsKey(email)) {
                    emailToAccountIdMap.put(email, i);
                } else {
                    dsu.union(i, emailToAccountIdMap.get(email));
                }
            }
        }

        Map<Integer, List<String>> components = new HashMap<>();
        for (String email : emailToAccountIdMap.keySet()) {
            final int group = emailToAccountIdMap.get(email);
            int groupRep = dsu.find(group);

            if (!components.containsKey(groupRep)) {
                components.put(groupRep, new ArrayList<>());
            }

            components.get(groupRep).add(email);
        }

        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int group : components.keySet()) {
            final List<String> component = components.get(group);
            Collections.sort(component);
            component.add(0, accountList.get(group).get(0));
            mergedAccounts.add(component);
        }

        return mergedAccounts;
    }

    public static void main(String[] args) {

        String[][] accountsArray = new String[][]{{"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"John", "johnsmith@mail.com", "john00@mail.com"}, {"Mary", "mary@mail.com"}, {"John", "johnnybravo@mail.com"}};

        final List<List<String>> accounts = Arrays.stream(accountsArray).map(Arrays::asList).collect(Collectors.toList());

        AccountMerge_LC721 accountMerge_lc721 = new AccountMerge_LC721();
        accountMerge_lc721.accountsMerge(accounts);
    }
}
