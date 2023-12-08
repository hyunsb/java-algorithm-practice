import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] a = new int[n];
        int [] b = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0, p2=0;

        while(p1<n && p2<m) {
            if(a[p1]<= b[p2]) {
                sb.append(a[p1++]+" ");
            }
            else {
                sb.append(b[p2++]+" ");
            }
        }
        
        if(p1==n) {
            for (int i = p2; i < m; i++) {
                sb.append(b[i]+" ");
            }
        }
        if(p2==m) {
            for (int i = p1; i < n; i++) {
                sb.append(a[i]+" ");
            }
        }
        System.out.println(sb);

    }
}
