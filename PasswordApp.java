import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class PasswordApp implements ActionListener{
    JButton b,b1;
    JFrame f;
    JLabel l;
    PasswordApp(){
        f = new JFrame("Password Helper");
        b = new JButton("Check Password Strength");
        b1 = new JButton("Generate a Password");
        l = new JLabel("Welcome to Password Helper");
        l.setBounds(95,50,250,30);
        l.setFont(new Font("Arial",Font.BOLD,16));
        b.setBounds(50,120,300,50);
        b1.setBounds(50,200, 300, 50);
        f.add(l);
        f.add(b);
        f.add(b1);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.addActionListener(this);
        b1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b){
            strengthCheck();
        }
        if(e.getSource() == b1){
            generatePassword();
        }
    }

    public void strengthCheck(){
        String password = JOptionPane.showInputDialog("Enter your password");

        boolean length = false, upper = false, lower = false, number = false, symbol = false;

        for(int i = 0; i<password.length(); i++){
            char c = password.charAt(i);
            if(Character.isDigit(c)){
                number = true;
            }
            if(Character.isUpperCase(c)){
                upper = true;
            }
            if(Character.isLowerCase(c)){
                lower = true;
            }
            if(c=='!'||c=='@'||c=='#'||c=='$'||c=='%'||c=='^'||c=='&'||c=='*'){
                symbol = true;
            }
        }

        if(password.length()>=12){
            length = true;
        }
        else{
            JOptionPane.showMessageDialog(null,"Your password should be atleast 12 characters long!");
        }

        if(upper == false){
            JOptionPane.showMessageDialog(null,"Your password should contain uppercase letters!");
        }

        if(lower == false){
            JOptionPane.showMessageDialog(null,"Your password should contain lowercase letters!");
        }

        if(number == false){
            JOptionPane.showMessageDialog(null, "Your password should contain numbers!");
        }

        if(symbol == false){
            JOptionPane.showMessageDialog(null, "Your password should contain symbols!");
        }

        if(length == true && upper == true && lower == true && number == true && symbol == true){
            JOptionPane.showMessageDialog(null, "Your password is strong!");
        }
    }

    public void generatePassword(){
        String password = "";
        String[] wordQ = {"What is your favorite book or novel?","What is the name of the street you grew up on?","What is the name of the city you grew up in?","What is the name of the first school you attended?","What is the name of your favourite dish?","What is your favourite animal?","What is the title of the last book you read?","What is the name of the college you attended?"};
        String[] numberQ = {"In which year were you born?", "How many siblings do you have?","What is the sum of your birthdate (Date+Month+Year)","How many letters are there in your full name?"};
        String[] symbols = {"!","@","#","$","%","^","&","*"};
        int w,n,s;
        Random random = new Random();
        w = random.nextInt(wordQ.length);
        n = random.nextInt(numberQ.length);
        s = random.nextInt(symbols.length);
        String wtemp = JOptionPane.showInputDialog(wordQ[w]);
        String ntemp = JOptionPane.showInputDialog(numberQ[n]);
        password = wtemp + ntemp + symbols[s];
        if(password.length()<12){
            int t = random.nextInt(symbols.length);
            password+=symbols[t];
        }
        JOptionPane.showMessageDialog(null, "Generated Password: "+password);
    }

    public static void main(String[] args){

        PasswordApp t = new PasswordApp();

    }
}