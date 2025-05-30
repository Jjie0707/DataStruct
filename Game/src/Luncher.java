import game.Game;
import login_game.Login;
import register_game.Register;

public class Luncher {
    public static void main(String[] args) {
        // 创建一个游戏主界面
        Game game=new Game();

        //创建一个登录主界面
        Login login =new Login();

        //创建一个注册主界面
        Register register=new Register();
    }
}
