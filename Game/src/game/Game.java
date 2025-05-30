package game;


import javax.swing.*;

public class Game extends JFrame {

    public Game(){
        //创建主界面时就完成属性的设置
        initGame();

        //接下来完成主游戏界面的菜单设置
        initMenu();





        //默认隐藏，改成可见
        this.setVisible(true);
    }








    private void initMenu() {
        JMenuBar menubar=new JMenuBar();

        JMenu functionmenu=new JMenu("功能");
        JMenuItem change=new JMenuItem("更换图片");
        JMenuItem relog=new JMenuItem("重新登录");
        JMenuItem regame=new JMenuItem("重新游戏");
        JMenuItem exit=new JMenuItem("退出游戏");
        functionmenu.add(change);
        functionmenu.add(regame);
        functionmenu.add(relog);
        functionmenu.add(exit);


        JMenu aboutmenu=new JMenu("关于我");
        JMenuItem wechat=new JMenuItem("微信");
        aboutmenu.add(wechat);

        menubar.add(functionmenu);
        menubar.add(aboutmenu);

        this.setJMenuBar(menubar);
    }

    private void initGame() {
        this.setSize(600,600);

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
