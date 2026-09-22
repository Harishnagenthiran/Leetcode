class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int steps = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                String curr = q.poll();

                if (curr.equals(endWord)) {
                    return steps;
                }

                char[] arr = curr.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        arr[j] = ch;

                        String name = new String(arr);

                        if (set.contains(name)) {
                            q.offer(name);
                            set.remove(name);
                        }
                    }

                    arr[j] = original;
                }
            }

            steps++;
        }

        return 0;
    }
}