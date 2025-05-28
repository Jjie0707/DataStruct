package game;


import javax.swing.*;

public class Game extends JFrame {

    public Game(){
        //创建主界面时就完成属性的设置
        initGame();

        //接下来完成主游戏界面的菜单设置
        JMenuBar menubar=new JMenuBar();

        JMenu functionmenu=new JMenu("功能");
        



        JMenu aboutmenu=new JMenu("关于我");


    }

    private void initGame() {
        this.setSize(600,600);

        //默认隐藏，改成可见
        this.setVisible(true);
        //设置界面名字
        this.setTitle("拼图游戏（单机）");
        //设置关闭模式，关闭一个页面全部关闭
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //设置始终在最上层
        this.setAlwaysOnTop(true);

        //默认左上角改为中间
        this.setLocationRelativeTo(null);
    }

}
