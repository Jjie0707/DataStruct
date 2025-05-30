package register_game;

import javax.swing.*;

public class Register extends JFrame {
    public Register(){
        //创建注册界面就完成属性的设置
        initRegister();



    }

    private void initRegister() {
        this.setSize(550,550);

        //默认隐藏，改成可见
        this.setVisible(true);
        //设置界面名字
        this.setTitle("注册账号");
        //设置关闭模式，关闭一个页面全部关闭
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //设置始终在最上层
        this.setAlwaysOnTop(true);

        //默认左上角改为中间
        this.setLocationRelativeTo(null);
    }

}
