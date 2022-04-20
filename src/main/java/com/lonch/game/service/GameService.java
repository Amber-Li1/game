package com.lonch.game.service;

import com.lonch.game.constants.Scores;
import com.lonch.game.dto.ChessColorStringDto;
import com.lonch.game.entity.GameEntity;
import com.lonch.game.entity.Chess;
import com.lonch.game.utils.CheckPieceValidityUtil;
import com.lonch.game.utils.ChessUtil;
import com.lonch.game.utils.RollPieceUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @description:
 * @author: lpx
 * @create: 2022-03-16 20:48
 */
@Service
public class GameService {

    /**
     * //1.根据落子的坐标找到对应的八个节点
     *         //2.判断八个节点，
     *         // 如果节点为空，不处理，
     *         // 如果不为空，判断是否颜色相同
     *         // 如果相同，停止查找
     *         // 如果不相同，按照同一方向查找，是否能找到相同颜色的棋子
     *         // 如果能找到，则记录路径上的所有棋子
     *         // 如果找不到，则不处理
     *         //3.判断2里是否有找到的棋子，如果有则合法，如果没有则不合法。
     * @param gameEntity
     * @param chess
     */
    public Boolean checkValid(GameEntity gameEntity, Chess chess){

        Chess[][] chessboard =gameEntity.getChessBoardEntity().getChess();

        if(chessboard[chess.getX()][chess.getY()]!=null){
            return false;
        }

        //计数器
        int count=0;
        List<int[]> hasPieces=new ArrayList<>();
        //正上方校验
        if(chess.x>=1){
            chess.front= chessboard[chess.x-1][chess.y];
            hasPieces= CheckPieceValidityUtil.checkFront(chess,count,hasPieces, chess.colorType);
        }
        //左上方校验
        if(chess.x>0 && chess.y>0 && chessboard[chess.x-1][chess.y-1]!=null){
            chess.leftfront= chessboard[chess.x-1][chess.y-1];
            hasPieces=CheckPieceValidityUtil.checkLeftFront(chess,count,hasPieces, chess.colorType);
        }
        //左侧校验
        if(chess.y>0 && chessboard[chess.x][chess.y-1]!=null){
            chess.left= chessboard[chess.x][chess.y-1];
            hasPieces=CheckPieceValidityUtil.checkLeft(chess,count,hasPieces, chess.colorType);
        }
        //左下方校验
        if(chess.x<7 && chess.y>0 && chessboard[chess.x+1][chess.y-1]!=null){
            chess.leftbehind= chessboard[chess.x+1][chess.y-1];
            hasPieces=CheckPieceValidityUtil.checkLeftBehind(chess,count,hasPieces, chess.colorType);
        }
        //正下方校验
        if(chess.x<7 && chessboard[chess.x+1][chess.y]!=null){
            chess.behind= chessboard[chess.x+1][chess.y];
            hasPieces=CheckPieceValidityUtil.checkBehind(chess,count,hasPieces, chess.colorType);
        }
        //右下方校验
        if(chess.x<7 && chess.y<7 && chessboard[chess.x+1][chess.y+1]!=null){
            chess.rightbehind= chessboard[chess.x+1][chess.y+1];
            hasPieces=CheckPieceValidityUtil.checkRightBehind(chess,count,hasPieces, chess.colorType);
        }
        //右侧校验
        if(chess.y<7 && chessboard[chess.x][chess.y+1]!=null){
            chess.right= chessboard[chess.x][chess.y+1];
            hasPieces=CheckPieceValidityUtil.checkRight(chess,count,hasPieces, chess.colorType);
        }
        //右上方校验
        if(chess.x>0 && chess.y<7 && chessboard[chess.x-1][chess.y+1]!=null){
            chess.rightfront= chessboard[chess.x-1][chess.y+1];
            hasPieces=CheckPieceValidityUtil.checkRightFront(chess,count,hasPieces, chess.colorType);
        }

        if(hasPieces.size()<=0){
            return false;
        }
        return true;
    }

    public void putChess(GameEntity gameEntity, Chess chess){
        //落子
        Chess[][] chessboard =gameEntity.getChessBoardEntity().chess;
        chessboard[chess.x][chess.y]= chess;

        //计数器
        int count=0;
        List<int[]> hasPieces=new ArrayList<>();
        //正上方校验
        if(chess.x>0 && chessboard[chess.x-1][chess.y]!=null){
            chess.front= chessboard[chess.x-1][chess.y];
            chessboard[chess.x-1][chess.y].behind= chess;
            hasPieces= CheckPieceValidityUtil.checkFront(chess,count,hasPieces, chess.colorType);
            if(hasPieces.size()>0){
                RollPieceUtil.rollFront(chessboard, chess,hasPieces.get(0));
            }
        }
        //左上方校验
        if(chess.x>0 && chess.y>0 && chessboard[chess.x-1][chess.y-1]!=null){
            hasPieces.clear();
            chess.leftfront= chessboard[chess.x-1][chess.y-1];
            chessboard[chess.x-1][chess.y-1].rightbehind= chess;
            hasPieces=CheckPieceValidityUtil.checkLeftFront(chess,count,hasPieces, chess.colorType);
            if(hasPieces.size()>0){
                RollPieceUtil.rollLeftFront(chessboard, chess,hasPieces.get(0));
            }
        }
        //左侧校验
        if(chess.y>0 && chessboard[chess.x][chess.y-1]!=null){
            hasPieces.clear();
            chess.left= chessboard[chess.x][chess.y-1];
            chessboard[chess.x][chess.y-1].right= chess;
            hasPieces=CheckPieceValidityUtil.checkLeft(chess,count,hasPieces, chess.colorType);
            if(hasPieces.size()>0){
                RollPieceUtil.rollLeft(chessboard, chess,hasPieces.get(0));
            }
        }
        //左下方校验
        if(chess.x<7 && chess.y>0 && chessboard[chess.x+1][chess.y-1]!=null){
            hasPieces.clear();
            chess.leftbehind= chessboard[chess.x+1][chess.y-1];
            chessboard[chess.x+1][chess.y-1].rightfront= chess;
            hasPieces=CheckPieceValidityUtil.checkLeftBehind(chess,count,hasPieces, chess.colorType);
            if(hasPieces.size()>0){
                RollPieceUtil.rollLeftBehind(chessboard, chess,hasPieces.get(0));
            }
        }
        //正下方校验
        if(chess.x<7 && chessboard[chess.x+1][chess.y]!=null){
            hasPieces.clear();
            chess.behind= chessboard[chess.x+1][chess.y];
            chessboard[chess.x+1][chess.y].front= chess;
            hasPieces=CheckPieceValidityUtil.checkBehind(chess,count,hasPieces, chess.colorType);
            if(hasPieces.size()>0){
                RollPieceUtil.rollBehind(chessboard, chess,hasPieces.get(0));
            }
        }
        //右下方校验
        if(chess.x<7 && chess.y<7 && chessboard[chess.x+1][chess.y+1]!=null){
            hasPieces.clear();
            chess.rightbehind= chessboard[chess.x+1][chess.y+1];
            chessboard[chess.x+1][chess.y+1].leftfront= chess;
            hasPieces=CheckPieceValidityUtil.checkRightBehind(chess,count,hasPieces, chess.colorType);
            if(hasPieces.size()>0){
                RollPieceUtil.rollRightBehind(chessboard, chess,hasPieces.get(0));
            }
        }
        //右侧校验
        if(chess.y<7 && chessboard[chess.x][chess.y+1]!=null){
            hasPieces.clear();
            chess.right= chessboard[chess.x][chess.y+1];
            chessboard[chess.x][chess.y+1].left= chess;
            hasPieces=CheckPieceValidityUtil.checkRight(chess,count,hasPieces, chess.colorType);
            if(hasPieces.size()>0){
                RollPieceUtil.rollRight(chessboard, chess,hasPieces.get(0));
            }
        }
        //右上方校验
        if(chess.x>0 && chess.y<7 && chessboard[chess.x-1][chess.y+1]!=null){
            hasPieces.clear();
            chess.rightfront= chessboard[chess.x-1][chess.y+1];
            chessboard[chess.x-1][chess.y+1].leftbehind= chess;
            hasPieces=CheckPieceValidityUtil.checkRightFront(chess,count,hasPieces, chess.colorType);
            if(hasPieces.size()>0){
                RollPieceUtil.rollRightFront(chessboard, chess,hasPieces.get(0));
            }
        }

    }

    public ChessColorStringDto autoPutChess(GameEntity gameEntity, String color){
        Chess[][] chessboard =gameEntity.getChessBoardEntity().chess;
        //可下棋子集合
        List<Chess> chessList=new ArrayList<Chess>();
        for(int i=0;i<chessboard.length; i++){
            for(int j=0;j<chessboard[i].length;j++){
                Chess chessNew=new Chess();
                chessNew.setX(i);
                chessNew.setY(j);
                chessNew.setColorType(color);
                Boolean flag=checkValid(gameEntity,chessNew);
                if(flag){
                    chessList.add(chessNew);
                }
            }
        }
        if(CollectionUtils.isEmpty(chessList)){
            return null;
        }
        Chess maxScoresChess=getBestChess(chessboard,chessList);
        putChess(gameEntity,maxScoresChess);
        //打印棋盘数据
        System.out.println("棋盘数据如下：");
        for(Chess[] chesses :chessboard){
           for(Chess ches:chesses){
               if(ches!=null){
                   System.out.println(ches.getX()+"-"+ches.getY()+"-"+ches.getColorType());
               }
           }
        }
        return ChessUtil.transEntity2ChessColorStringDto(maxScoresChess);
    }

    /**
     * 1.先计算是否是金角，如果是，直接取值。
     * 2.计算落子点在第几象限。以下以第一象限为例
     * 3.计算落子与金角的 x,y 之差的平方和，
     *      如果<=2，在最差点,
     *      <=8：如果落子x+y是偶数，则取次优点
     *          如果落子x+y是偶数，则取次次差点
     *      否则：次差点
     *  以此类推。
     * @param chessboadLength
     * @param chess
     * @return
     */
    public int getScores(int chessboadLength,Chess chess) {
//        System.out.print("可下棋子集合==");
//        Chess maxScoresChess=null;
//
//        int maxScore=Integer.MIN_VALUE;

//        for (Chess chess : chessList) {
            System.out.print(chess.getX()+"-"+chess.getY()+",");
            int score=0;

            int[][] highest = {{0,0}, {0, chessboadLength - 1}, {chessboadLength - 1, 0}, {chessboadLength - 1, chessboadLength- 1}};
            //金角
            for(int[] each : highest) {
                if(each[0]==chess.getX() && each[1] == chess.getY()){
                    score+= Scores.SCORE_HIGHEST;
                    return score;
                }
            }
            int boardlen=chessboadLength/2;
            //第一象限
            if(chess.getX()<boardlen && chess.getY() <boardlen){
                double distance=Math.pow(chess.getX(),2)+Math.pow(chess.getY(),2);
                if(distance<=2){
                    score-=Scores.SCORE_HIGHEST;
                }else if(distance <=8){
                    if((chess.getX()+chess.getY()) % 2 == 0){
                        score += Scores.SCORE_HIGH;
                    }else {
                        score-=Scores.SCORE_MIDDLE;
                    }
                }else{
                    score-=Scores.SCORE_HIGH;
                }
            }
            //第二象限
            if(chess.getX()<boardlen && chess.getY() >=boardlen){
                double distance=Math.pow(chess.getX(),2)+Math.pow(chess.getY()-chessboadLength+1,2);
                if(distance<=2){
                    score-=Scores.SCORE_HIGHEST;
                }else if(distance <=8){
                    if((chess.getX()+chess.getY() )% 2 > 0){
                        score += Scores.SCORE_HIGH;
                    }else{
                        score-=Scores.SCORE_MIDDLE;
                    }
                }else{
                    score-=Scores.SCORE_HIGH;
                }
            }
            //第三象限
            if(chess.getX()>=boardlen && chess.getY() >=boardlen){
                double distance=Math.pow(chess.getX()-chessboadLength+1,2)+Math.pow(chess.getY()-chessboadLength+1,2);
                if(distance<=2){
                    score-=Scores.SCORE_HIGHEST;
                }else if(distance <=8){
                    if((chess.getX()+chess.getY() )% 2 == 0){
                        score += Scores.SCORE_HIGH;
                    }else{
                        score-=Scores.SCORE_MIDDLE;
                    }
                }else{
                    score-=Scores.SCORE_HIGH;
                }
            }
            //第四象限
            if(chess.getX()>=boardlen && chess.getY() <boardlen){
                double distance=Math.pow(chess.getX()-chessboadLength+1,2)+Math.pow(chess.getY(),2);
                if(distance<=2){
                    score-=Scores.SCORE_HIGHEST;
                }else if(distance <=8){
                    if((chess.getX()+chess.getY() )% 2 > 0){
                        score += Scores.SCORE_HIGH;
                    }else{
                        score-=Scores.SCORE_MIDDLE;
                    }
                }else{
                    score-=Scores.SCORE_HIGH;
                }
            }
            System.out.println("评分为："+score);
//            if(score>maxScore){
//                maxScore=score;
//                maxScoresChess=chess;
//            }
//        }
//        System.out.println("返回的棋子是=="+maxScoresChess.getX()+"-"+maxScoresChess.getY()+",");
//
//        return maxScoresChess;
        return score;
    }


    /**
     * 根据棋盘和可下棋子获取最终落子
     * @param chessboard
     * @param chessList
     * @return
     */
    public Chess getBestChess(Chess[][] chessboard,List<Chess> chessList){
        System.out.print("可下棋子集合==");
        Chess bestChess=null;

        int maxScore=Integer.MIN_VALUE;

        for(Chess chess:chessList){

            //获取当前落子的得分
            int currentScore= getScores(chessboard.length,chess);

            //如果使用该子，对方棋手最有可能获取的最大分值
            int nextScore=getNextChessScore(chessboard,chess);

            //判断当前分支和对方分值差，差值越大，结果越好。
            if(currentScore-nextScore>maxScore){
                maxScore=currentScore-nextScore;
                bestChess=chess;
            }
        }

        return bestChess;
    }

    /**
     * 模拟场景：
     * 该棋盘中，如果落了这个棋子，
     * 返回 对方可以落子的最大分值
     * @param chessboard
     * @param chess
     * @return
     */
    public int getNextChessScore(Chess[][] chessboard,Chess chess){

        String fileId=UUID.randomUUID().toString().replace("-", "")+".txt";
        try {
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(fileId));
            os.writeObject(chessboard);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileId));
            Chess[][] chessboardNew= (Chess[][]) ois.readObject();
            chessboardNew[chess.getX()][chess.getY()]=chess;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return 1;
    }
}
