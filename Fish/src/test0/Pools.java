package test0;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;


public class Pools {

    public Pool[] pools;

    //传入的参数是池塘的个数
    public void init(int size){
        Random r=new Random();
        this.pools=new Pool[size];

        //传入参数后 会同时调用随机函数为鱼塘初始化数据
        for(int i=0;i<size;i++){
            Pool tem=new Pool();
            tem.T=r.nextInt(5)+1;//Ti的范围是[1,5]
            tem.F=r.nextInt(20)+1;
            tem.D=(r.nextInt(tem.F)+1)/2+1;
            pools[i]=tem;
        }
    }

    // 通过这个钓鱼的方法来计算出小明可以钓到的鱼的数量
    // 鱼塘的大小和小明的时间通过参数size和time来传递
    public void fish(int size,int time){
        //检查一下时间和池塘大小的合理性,不合理直接返回0条鱼
        if(size<=0 || time<=0) {
            String ret ="最终统计结果，小明路途花费合计0分钟，在各池塘停留合计0分钟，总计耗时0分钟，获得鱼量合计0条";
            writeToFishFile(ret);
            return;
        }

        //time单位是小时，我们的问题的基本单位是分钟，直接把它变成分钟
        time*=60;
        //初始化鱼塘
        this.init(size);

        //如果不需要展示鱼塘可以注释
        showPools();

        //count统计钓到的鱼的数量，time1和time2分别统计路上和在各池塘总共停留的时间
        int count=0,time1=0,time2=0;

        //枚举每一个池塘作为小明钓鱼的终点
        for (int k = 0; k < size; k++) {
            //计算走到预定终点池塘的走路时间
            int walk = 0;
            for (int i = 0; i <= k; i++) walk += 5 * pools[i].T;
            if (walk >= time) break;   // 走不完，更大的 k 更走不完

            //建立一个大堆来记录可以获得的鱼的收益(一个数代表一个单位时间5min)
            PriorityQueue<Integer> heap = new PriorityQueue<>((e1,e2)->e2-e1);
            for (int i = 0; i <= k; i++) {
                int t = 0;
                while (true) {//只要该鱼塘的收益还大于0就可以加到大堆里，至于能否取得到还要看后面的时间校验
                    int g = pools[i].F - t * pools[i].D;
                    if (g <= 0) break;
                    heap.offer(g);
                    t++;
                }
            }

            //用剩余时间钓最大的鱼的数量
            int left = time - walk;
            int curFish = 0, curFishTime = 0;

            //根据实际结果可以得到结论，之哟啊钓鱼时间是相同的和逻辑上先在哪个鱼塘钓鱼没有关系(终点鱼塘相同的情况下)
            //所以我们只需要枚举出以每个鱼塘为终点的情况就可以了
            while (!heap.isEmpty() && left >= 5) {
                curFish += heap.poll();
                curFishTime += 5;
                left -= 5;
            }
            //    更新答案
            if (curFish >= count) {
                count = curFish;
                time1 = walk;
                time2 = curFishTime;
            }
        }
        int sumTime=time1+time2;
        String ret="最终统计结果，小明路途花费合计"+time1+
                "分钟，在各池塘停留合计"+time2+
                "分钟，总计耗时"+sumTime+
                "分钟，获得鱼量合计"+count+"条";
        writeToFishFile(ret);
    }
    public void showPools(){
        System.out.println("展示鱼塘:");
        for(Pool tem:pools){
            System.out.println(tem.T+" "+ tem.F+" "+ tem.D);
        }
    }
    private static void writeToFishFile(String content) {
        // 如果想改成覆盖写入，把第二个参数 false 即可
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("fish.txt", true))) {
            writer.write(content);
            writer.newLine(); // 换行，方便多次调用
        } catch (IOException e) {
            e.printStackTrace(); // 生产环境可替换为日志
        }
    }
}
