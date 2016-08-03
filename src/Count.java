import javax.swing.JOptionPane;

class Count {
    int[][] array = new int[4][4];
    int[][] checkArray = new int[4][4];
    int mls;

    void Random() {
        int p = 0;
        for (int line[] : array) {
            for (int elem : line) {
                if (elem == 0) p++;
            }
        }
        int rdm = (int) (Math.random() * p + 1);
        int vx, vy, k;
        vx = vy = k = 0;
        endrandom:
        for (int line[] : array) {
            vy = 0;
            for (int elem : line) {
                if (elem == 0) {
                    k++;
                }
                if (k == rdm) break endrandom;
                vy++;
            }
            vx++;
        }
        array[vx][vy] = 2;
    }

    void Print() {
        for (int j = 0; j < 4; j++) {
            for (int t = 0; t < 4; t++) {
                Window.jtfArray[j][t].setText("" + array[j][t]);
            }
        }
    }

    void Read() {
        try {
            for (int j = 0; j < 4; j++) {
                for (int t = 0; t < 4; t++) {
                    array[j][t] = Integer.parseInt(Window.jtfArray[j][t].getText());
                }
            }
        } catch (Exception ex) {
        } //{JOptionPane.showMessageDialog(null, "Только цифры!");}
    }

    void Moves(String j) {
        switch (j) {
            case "n": {
                for (int x = 0; x < array.length; x++) {
                    for (int y = 0; y < array.length; y++) {
                        array[x][y] = 0;
                    }
                }
                Window.lsumm.setText("" + 0);
                Random();
                Random();
                break;
            }
            case "h": {
                JOptionPane.showMessageDialog(null, "Use your arrow keys to move the tiles."
                        + "\nWhen two tiles with the same number touch,\nthey merge into one!"
                        + "\ncreated by Gabriele Cirulli, done by Titarenko");
            }
            case "l": {
                for (int lx = 0; lx < 4; lx++) {
                    if (array[lx][0] == 0) {
                        int rnil = 0;
                        while (array[lx][0] == 0) {
                            array[lx][0] = array[lx][1];
                            array[lx][1] = array[lx][2];
                            array[lx][2] = array[lx][3];
                            array[lx][3] = 0;
                            rnil++;
                            if (rnil == 3) break;
                        }
                    }
                    if (array[lx][1] == 0) {
                        int rnil = 0;
                        while (array[lx][1] == 0) {
                            array[lx][1] = array[lx][2];
                            array[lx][2] = array[lx][3];
                            array[lx][3] = 0;
                            rnil++;
                            if (rnil == 2) break;
                        }
                    }
                    if (array[lx][2] == 0) {
                        array[lx][2] = array[lx][3];
                        array[lx][3] = 0;
                    }
                    if (array[lx][0] == array[lx][1]) {
                        array[lx][0] += array[lx][1];
                        array[lx][1] = array[lx][2];
                        array[lx][2] = array[lx][3];
                        array[lx][3] = 0;
                        int rez = Integer.parseInt(Window.lsumm.getText());
                        Window.lsumm.setText(rez + array[lx][0] + "");
                    }
                    if (array[lx][1] == array[lx][2]) {
                        array[lx][1] += array[lx][2];
                        array[lx][2] = array[lx][3];
                        array[lx][3] = 0;
                        int rez = Integer.parseInt(Window.lsumm.getText());
                        Window.lsumm.setText(rez + array[lx][1] + "");
                    }
                    if (array[lx][2] == array[lx][3]) {
                        array[lx][2] += array[lx][3];
                        array[lx][3] = 0;
                        int rez = Integer.parseInt(Window.lsumm.getText());
                        Window.lsumm.setText(rez + array[lx][2] + "");
                    }
                }
                break;
            }
            case "r": {
                for (int rx = 0; rx < 4; rx++) {
                    if (array[rx][3] == 0) {
                        int rnil = 0;
                        while (array[rx][3] == 0) {
                            array[rx][3] = array[rx][2];
                            array[rx][2] = array[rx][1];
                            array[rx][1] = array[rx][0];
                            array[rx][0] = 0;
                            rnil++;
                            if (rnil == 3) break;
                        }
                    }
                    if (array[rx][2] == 0) {
                        int rnil = 0;
                        while (array[rx][2] == 0) {
                            array[rx][2] = array[rx][1];
                            array[rx][1] = array[rx][0];
                            array[rx][0] = 0;
                            rnil++;
                            if (rnil == 2) break;
                        }
                    }
                    if (array[rx][1] == 0) {
                        array[rx][1] = array[rx][0];
                        array[rx][0] = 0;
                    }
                    if (array[rx][3] == array[rx][2]) {
                        array[rx][3] += array[rx][2];
                        array[rx][2] = array[rx][1];
                        array[rx][1] = array[rx][0];
                        array[rx][0] = 0;
                        int rez = Integer.parseInt(Window.lsumm.getText());
                        Window.lsumm.setText(rez + array[rx][3] + "");
                    }
                    if (array[rx][2] == array[rx][1]) {
                        array[rx][2] += array[rx][1];
                        array[rx][1] = array[rx][0];
                        array[rx][0] = 0;
                        int rez = Integer.parseInt(Window.lsumm.getText());
                        Window.lsumm.setText(rez + array[rx][2] + "");
                    }
                    if (array[rx][1] == array[rx][0]) {
                        array[rx][1] += array[rx][0];
                        array[rx][0] = 0;
                        int rez = Integer.parseInt(Window.lsumm.getText());
                        Window.lsumm.setText(rez + array[rx][1] + "");
                    }
                }
                break;
            }
            case "u": {
                for (int uy = 0; uy < 4; uy++) {
                    if (array[0][uy] == 0) {
                        int rnil = 0;
                        while (array[0][uy] == 0) {
                            array[0][uy] = array[1][uy];
                            array[1][uy] = array[2][uy];
                            array[2][uy] = array[3][uy];
                            array[3][uy] = 0;
                            rnil++;
                            if (rnil == 3) break;
                        }
                    }
                    if (array[1][uy] == 0) {
                        int rnil = 0;
                        while (array[1][uy] == 0) {
                            array[1][uy] = array[2][uy];
                            array[2][uy] = array[3][uy];
                            array[3][uy] = 0;
                            rnil++;
                            if (rnil == 2) break;
                        }
                    }
                    if (array[2][uy] == 0) {
                        array[2][uy] = array[3][uy];
                        array[3][uy] = 0;
                    }
                    if (array[0][uy] == array[1][uy]) {
                        array[0][uy] += array[1][uy];
                        array[1][uy] = array[2][uy];
                        array[2][uy] = array[3][uy];
                        array[3][uy] = 0;
                        int rez = Integer.parseInt(Window.lsumm.getText());
                        Window.lsumm.setText(rez + array[0][uy] + "");
                    }
                    if (array[1][uy] == array[2][uy]) {
                        array[1][uy] += array[2][uy];
                        array[2][uy] = array[3][uy];
                        array[3][uy] = 0;
                        int rez = Integer.parseInt(Window.lsumm.getText());
                        Window.lsumm.setText(rez + array[1][uy] + "");
                    }
                    if (array[2][uy] == array[3][uy]) {
                        array[2][uy] += array[3][uy];
                        array[3][uy] = 0;
                        int rez = Integer.parseInt(Window.lsumm.getText());
                        Window.lsumm.setText(rez + array[2][uy] + "");
                    }
                }
                break;
            }
            case "d": {
                for (int dy = 0; dy < 4; dy++) {
                    if (array[3][dy] == 0) {
                        int rnil = 0;
                        while (array[3][dy] == 0) {
                            array[3][dy] = array[2][dy];
                            array[2][dy] = array[1][dy];
                            array[1][dy] = array[0][dy];
                            array[0][dy] = 0;
                            rnil++;
                            if (rnil == 3) break;
                        }
                    }
                    if (array[2][dy] == 0) {
                        int rnil = 0;
                        while (array[2][dy] == 0) {
                            array[2][dy] = array[1][dy];
                            array[1][dy] = array[0][dy];
                            array[0][dy] = 0;
                            rnil++;
                            if (rnil == 2) break;
                        }
                    }
                    if (array[1][dy] == 0) {
                        array[1][dy] = array[0][dy];
                        array[0][dy] = 0;
                    }
                    if (array[3][dy] == array[2][dy]) {
                        array[3][dy] += array[2][dy];
                        array[2][dy] = array[1][dy];
                        array[1][dy] = array[0][dy];
                        array[0][dy] = 0;
                        int rez = Integer.parseInt(Window.lsumm.getText());
                        Window.lsumm.setText(rez + array[3][dy] + "");
                    }
                    if (array[2][dy] == array[1][dy]) {
                        array[2][dy] += array[1][dy];
                        array[1][dy] = array[0][dy];
                        array[0][dy] = 0;
                        int rez = Integer.parseInt(Window.lsumm.getText());
                        Window.lsumm.setText(rez + array[2][dy] + "");
                    }
                    if (array[1][dy] == array[0][dy]) {
                        array[1][dy] += array[0][dy];
                        array[0][dy] = 0;
                        int rez = Integer.parseInt(Window.lsumm.getText());
                        Window.lsumm.setText(rez + array[1][dy] + "");
                    }
                }
                break;
            }
        }
    }

    void equal() {
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++)
                checkArray[a][b] = array[a][b];
        }
    }

    boolean compare() {
        boolean check = false;
        ch:
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                if (array[a][b] != checkArray[a][b]) {
                    check = true;
                    break ch;
                }
            }
        }
        return check;
    }

    void win() {
        for (int wl[] : array)
            for (int w : wl)
                if (w == 2048 & mls == 0) {
                    JOptionPane.showMessageDialog(null, "Congratulation!\nIt's a victory!");
                    mls++;
                }
    }

    void gameOver() {
        String points = Window.lsumm.getText();
        int highest = 0;
        Read();
        equal();
        String Steps[] = {"l", "r", "u", "d"};
        fine:
        {
            for (String g : Steps) {
                Moves(g);
                if (compare()) break fine;
            }
            for (int x = 0; x < array.length; x++) {
                for (int y = 0; y < array.length; y++) {
                    if (array[x][y] > highest) highest = array[x][y];
                }
            }
            if (highest < 2048) JOptionPane.showMessageDialog(null, "You lose! \nTry again");
            else JOptionPane.showMessageDialog(null, "Game over! \nThanks for playing)"
                    + "\nYour score is " + points);
        }
        Window.lsumm.setText(points);
    }

}