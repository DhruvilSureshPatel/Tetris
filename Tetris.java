package some;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Tetris extends JFrame implements KeyListener{
    
    ArrayList<ArrayList<char[][]>> symbols = new ArrayList<>();
    int height = 200 , width = 200 , col = -1 , symbol = -1 , subSymbol = -1;
    boolean[][] board = new boolean[height/10 + 1][width/10 + 1];
    int score = 0;
    
    void run(Tetris t){
        initializeSymbols();
        t.setSize(width , height);
        t.setVisible(true);
        t.addKeyListener(t);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.generateSymbol();
    }
    
    void initializeSymbols(){
        ArrayList<char[][]> li = new ArrayList<>();
        
        char[][] square = new char[2][2];   //symbol at index 0.0; 
        square[0][0] = '#';
        square[0][1] = '#';
        square[1][0] = '#';
        square[1][1] = '#';
        li.add(square);
        symbols.add(li);
        li = new ArrayList<>();
        
        char[][] l = new char[2][3];
        l[0][0] = '#';                     //symbol at index 1.0;
        l[1][0] = '#';
        l[1][1] = '#';
        l[1][2] = '#';
        l[0][1] = ' ';
        l[0][2] = ' ';
        li.add(l);
        
        l = new char[3][2];                 //symbol at index 1.1;
        l[0][0] = ' ';
        l[0][1] = '#';
        l[1][0] = ' ';
        l[1][1] = '#';
        l[2][0] = '#';
        l[2][1] = '#';
        li.add(l);
        
        l = new char[2][3];
        l[0][0] = '#';                     //symbol at index 1.2;
        l[1][0] = ' ';
        l[1][1] = ' ';
        l[1][2] = '#';
        l[0][1] = '#';
        l[0][2] = '#';
        li.add(l);
        
        l = new char[3][2];                 //symbol at index 1.3;
        l[0][0] = '#';
        l[0][1] = '#';
        l[1][0] = '#';
        l[1][1] = ' ';
        l[2][0] = '#';
        l[2][1] = ' ';
        li.add(l);
        symbols.add(li);
        li = new ArrayList<>();
        
        char[][] line = new char[4][1];     //symbol at index 2.0;
        line[0][0] = '#';
        line[1][0] = '#';
        line[2][0] = '#';
        line[3][0] = '#';
        li.add(line);
        
        line = new char[1][4];     //symbol at index 2.1;
        line[0][0] = '#';
        line[0][1] = '#';
        line[0][2] = '#';
        line[0][3] = '#';
        li.add(line);
        symbols.add(li);
        li = new ArrayList<>();
        
        char[][] n = new char[2][3];
        n[0][0] = '#';
        n[0][1] = '#';
        n[0][2] = ' ';
        n[1][0] = ' ';
        n[1][1] = '#';
        n[1][2] = '#';
        li.add(n);
        
        n = new char[3][2];
        n[0][0] = ' ';
        n[0][1] = '#';
        n[2][0] = '#';
        n[1][0] = '#';
        n[1][1] = '#';
        n[2][1] = ' ';
        li.add(n);
        symbols.add(li);
        li = new ArrayList<>();
        
        char[][] t = new char[2][3];
        t[0][0] = ' ';
        t[0][1] = '#';
        t[0][2] = ' ';
        t[1][0] = '#';
        t[1][1] = '#';
        t[1][2] = '#';
        li.add(t);
        
        t = new char[3][2];
        t[0][0] = ' ';
        t[0][1] = '#';
        t[2][0] = ' ';
        t[1][0] = '#';
        t[1][1] = '#';
        t[2][1] = '#';
        li.add(t);
        
        t = new char[2][3];
        t[0][0] = '#';
        t[0][1] = '#';
        t[0][2] = '#';
        t[1][0] = ' ';
        t[1][1] = '#';
        t[1][2] = ' ';
        li.add(t);
        
        t = new char[3][2];
        t[0][0] = '#';
        t[0][1] = ' ';
        t[2][0] = '#';
        t[1][0] = '#';
        t[1][1] = '#';
        t[2][1] = ' ';
        li.add(t);
        symbols.add(li);
        li = new ArrayList<>();
        
        char[][] lr = new char[2][3];
        lr[0][0] = ' ';
        lr[0][1] = ' ';
        lr[0][2] = '#';
        lr[1][0] = '#';
        lr[1][1] = '#';
        lr[1][2] = '#';
        li.add(lr);
        
        lr = new char[3][2];
        lr[0][0] = '#';
        lr[0][1] = '#';
        lr[2][0] = ' ';
        lr[1][0] = ' ';
        lr[1][1] = '#';
        lr[2][1] = '#';
        li.add(lr);
        
        lr = new char[2][3];
        lr[0][0] = '#';
        lr[0][1] = '#';
        lr[0][2] = '#';
        lr[1][0] = '#';
        lr[1][1] = ' ';
        lr[1][2] = ' ';
        li.add(lr);
        
        lr = new char[3][2];
        lr[0][0] = '#';
        lr[0][1] = ' ';
        lr[2][0] = '#';
        lr[1][0] = '#';
        lr[1][1] = ' ';
        lr[2][1] = '#';
        li.add(lr);
        symbols.add(li);
        li = new ArrayList<>();
        
        char[][] nr = new char[2][3];
        nr[0][0] = ' ';
        nr[0][1] = '#';
        nr[0][2] = '#';
        nr[1][0] = '#';
        nr[1][1] = '#';
        nr[1][2] = ' ';
        li.add(nr);
        
        nr = new char[3][2];
        nr[0][0] = '#';
        nr[0][1] = ' ';
        nr[1][0] = '#';
        nr[1][1] = '#';
        nr[2][0] = ' ';
        nr[2][1] = '#';
        li.add(nr);
        symbols.add(li);
        
    }
    
    int random(int i, int j) {
        Random r = new Random();
        int num = r.nextInt((j - i) + 1) + i;
        return num;
    }
    
    void generateSymbol(){
        col = random(0 , (width/10)) * 10;
        symbol = random(0 , 6);
        int len = symbols.get(symbol).size();
        subSymbol = random(0 , len - 1);
        
        while(true){
            int le = symbols.get(symbol).get(subSymbol).length;
            int widthOfSymbol = le * 10 , reqdWidth = width - widthOfSymbol;
            if(col>=0 && col<=reqdWidth){
                break;
            }
            col = random(0 , (width/10)) * 10;
        }
    }
    
    void paintComponent(Graphics g){
        // do nothing....
    }
    
    int cur = 10;
    
    public void paint(Graphics g){
        
        Dimension d = getSize();
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        
        g.setColor(Color.BLACK);
        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j<board[i].length ; j++){
                int rr = i*10 , cc = j*10;
                if(board[i][j]){
                    g.drawString("#", cc, rr);
                }
            }
        }
        int row = cur;
        char[][] symb = symbols.get(symbol).get(subSymbol);
        for(int i=symb.length - 1 ; i>=0 ; i--){
            int co = col;
            for(int j=0 ; j<symb[0].length ; j++){
                g.drawString("" + symb[i][j], co, row);
                co += 10;
            }
            row -= 10;
            if(row<0){
                break;
            }
        }
        
        cur += 10;
        
        if(cur>height || !check(symb)){
            cur -= 10;
            for(int i=symb.length - 1 ; i>=0 ; i--){
                int co = col;
                for(int j=0 ; j<symb[i].length ; j++){
                    if(symb[i][j]=='#'){
                        board[cur/10][co/10] = true;
                    }
                    co += 10;
                }
                cur -= 10;
            }
            
            cur = 10;
            generateSymbol();
            repaint();
        }
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
        ArrayList<Integer> ans = inLine();
        if(ans.size()!=0){
            score += ans.size();
            for(int i=0 ; i<ans.size() ; i++){
                int num = ans.get(i).intValue();
                for(int j=num ; j>0 ; j--){
                    for(int k=0 ; k<board[0].length ; k++){
                        board[j][k] = board[j-1][k];
                    }
                }
                
                Arrays.fill(board[0], false);
            }
        }
*/
        
        
        repaint();
        
    }
    
    ArrayList<Integer> inLine(){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0 ; i<board.length ; i++){
            boolean b = true;
            for(int j=0 ; j<board[i].length ; j++){
                if(board[i][j]==false){
                    b = false;
                    break;
                }
            }
            
            if(b){
                ans.add(i);
            }
        }
        
        return ans;
    }
    
    boolean check(char[][] symb){
        if(cur>height){
            return false;
        }
        
        int rr = cur;
        for(int i=symb.length - 1 ; i>=0 ; i--){
            int co = col;
            for(int j=0 ; j<symb[i].length ; j++){
                if(symb[i][j]=='#'){
                    if(board[rr/10][co/10]){
                        return false;
                    }
                }
                co += 10;
            }
            rr -= 10;
        }
        
        return true;
    }

    public void keyTyped(KeyEvent e) {
        char pressed = e.getKeyChar();
        if(pressed=='a'){
            col -= 10;
        }
        else if(pressed=='d'){
            col += 10;
        }
        else if(pressed=='w'){
            subSymbol++;
            subSymbol %= symbols.get(symbol).size();
        }
        
        char[][] c = symbols.get(symbol).get(subSymbol);
        int widthOfSymbol = c[0].length * 10 , reqdWidth = width - widthOfSymbol;
        
        if(col<0){
            col = 0;
        }
        else if(col>reqdWidth){
            col = reqdWidth;
        }
        
        
        ArrayList<Integer> ans = inLine();
        System.out.println(ans);
        if(ans.size()!=0){
            score += ans.size();
            for(int i=0 ; i<ans.size() ; i++){
                int num = ans.get(i).intValue();
                for(int j=num ; j>0 ; j--){
                    for(int k=0 ; k<board[0].length ; k++){
                        board[j][k] = board[j-1][k];
                    }
                }
                
                Arrays.fill(board[0], false);
            }
        }
        
        repaint();
    }
    
    public void keyPressed(KeyEvent e) {   
    }
    
    public void keyReleased(KeyEvent e) {
    }
}
