import java.io.*;
import java.io.File;
import java.util.*;
import java.lang.*;

public class Main {
    int n, m;
    Integer[][] a= new Integer[101][101];
    
    Integer[][] viz= new Integer[101][101];
    int d = 0;
    int dx[] = {-2 , -2 , -1 , -1 , 1 , 1 , 2 , 2};
    int dy[] = {-1 , 1 , -2 , 2 , -2 , 2 , -1 , 1};
    Integer[][] sol, ans = new Integer[101][2];

    public Boolean Check(int x , int y)
    {
        return (1 <= x && x <= n && 1 <= y && y <= m);
    }

    public void Back(int L , int C)
    {
        if(L == n && C == m)
        {
            for(int i = 1 ; i <= d ; i++)
                System.out.println(ans[i][0] + " " + ans[i][1]);
            System.exit(0);
        }
        else
        {
            int x , y;
            for(int k = 0 ; k < 8 ; k++)
            {
                x = L + dx[k];
                y = C + dy[k];
                if(Check(x , y))
                    if(a[x][y] != 1 && viz[x][y]==0)
                    {
                        d++;
                        ans[d][0] = x; ans[d][1] = y;
                        viz[x][y] = 1;
                        Back(x , y);
                        viz[x][y] = 0;
                        --d;
                    }
            }
        }
    }

    public void exec() {
        Scanner myReader = new Scanner(System.in);
        System.out.println("Enter number of rows");
        n = myReader.nextInt();
        System.out.println("Enter number of columns");
        m = myReader.nextInt();

        for(int i = 0; i <= n; i++)
            for(int j = 0; j <= m; j++){
                viz[i][j] = 0;
                a[i][j] = 0;
        }
                
        System.out.println("Enter number of obstacles");
        int nr = myReader.nextInt();

        System.out.println("Enter coordinates of obstacles");
        for(int i = 1; i <= nr; i++) {
            int row, col;
            row = myReader.nextInt();
            col = myReader.nextInt();
            a[row][col] = 1;
        }
        System.out.println("Solution:");
        viz[1][1] = 1;
        Back(1 , 1);
    }

    public static void main(String[] args){
        Main Obj = new Main();
        Obj.exec();
    }
}


