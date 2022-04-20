package com.lonch.game.utils;

import com.lonch.game.entity.Chess;

import java.util.List;

/**
 * @description: 校验棋子合法性工具
 * @author: lpx
 * @create: 2022-02-06 17:13
 */
public class CheckPieceValidityUtil {

    //正上方递归检查
//    public static List<int[]> checkFront(int x, int y, int color, Piece[][] pieces, List<int[]> hasPieces, int count){
//        //是否顶点
//        if(x==0){
//            return hasPieces;
//        }
//        //正上方节点
//        Piece front = pieces[x-1][y];
//        //是否空节点
//        if(front==null){
//            return hasPieces;
//        }
//        //是否相同颜色
//        if(front.getColorType()==color){
//            if(count == 0){
//                return hasPieces;
//            }else{
//                int[] hasPiece=new int[]{x-1,y};
//                hasPieces.add(hasPiece);
//            }
//        }
//        hasPieces= checkFront(x-1,y,color,pieces,hasPieces,++count);
//        return hasPieces;
//    }

    //正上方递归检查2
    public static List<int[]> checkFront(Chess chess, int count, List<int[]> hasPieces, String color){
        Chess frontNew= chess.getFront();
        if(frontNew==null){
            return hasPieces;
        }
        if(frontNew.getColorType().equals(color)){
            if(count == 0){
                return hasPieces;
            }else{
                int[] hasPiece=new int[]{frontNew.getX(),frontNew.getY()};
                hasPieces.add(hasPiece);
            }
        }
        hasPieces=checkFront(frontNew,++count,hasPieces,color);
        return hasPieces;
    }


    //左上方递归检查
    public static List<int[]> checkLeftFront(Chess chess, int count, List<int[]> hasPieces, String color){
        Chess frontNew= chess.getLeftfront();
        if(frontNew==null){
            return hasPieces;
        }
        if(frontNew.getColorType().equals(color)){
            if(count == 0){
                return hasPieces;
            }else{
                int[] hasPiece=new int[]{frontNew.getX(),frontNew.getY()};
                hasPieces.add(hasPiece);
            }
        }
        hasPieces=checkLeftFront(frontNew,++count,hasPieces,color);
        return hasPieces;
    }

    //左侧递归检查
    public static List<int[]> checkLeft(Chess chess, int count, List<int[]> hasPieces, String color){
        Chess frontNew= chess.getLeft();
        if(frontNew==null){
            return hasPieces;
        }
        if(frontNew.getColorType().equals(color)){
            if(count == 0){
                return hasPieces;
            }else{
                int[] hasPiece=new int[]{frontNew.getX(),frontNew.getY()};
                hasPieces.add(hasPiece);
            }
        }
        hasPieces=checkLeft(frontNew,++count,hasPieces,color);
        return hasPieces;
    }

    //左下方递归检查
    public static List<int[]> checkLeftBehind(Chess chess, int count, List<int[]> hasPieces, String color){
        Chess frontNew= chess.getLeftbehind();
        if(frontNew==null){
            return hasPieces;
        }
        if(frontNew.getColorType().equals(color)){
            if(count == 0){
                return hasPieces;
            }else{
                int[] hasPiece=new int[]{frontNew.getX(),frontNew.getY()};
                hasPieces.add(hasPiece);
            }
        }
        hasPieces=checkLeftBehind(frontNew,++count,hasPieces,color);
        return hasPieces;
    }

    //正下方递归检查
    public static List<int[]> checkBehind(Chess chess, int count, List<int[]> hasPieces, String color){
        Chess frontNew= chess.getBehind();
        if(frontNew==null){
            return hasPieces;
        }
        if(frontNew.getColorType().equals(color)){
            if(count == 0){
                return hasPieces;
            }else{
                int[] hasPiece=new int[]{frontNew.getX(),frontNew.getY()};
                hasPieces.add(hasPiece);
            }
        }
        hasPieces=checkBehind(frontNew,++count,hasPieces,color);
        return hasPieces;
    }

    //右下方递归检查
    public static List<int[]> checkRightBehind(Chess chess, int count, List<int[]> hasPieces, String color){
        Chess frontNew= chess.getRightbehind();
        if(frontNew==null){
            return hasPieces;
        }
        if(frontNew.getColorType().equals(color)){
            if(count == 0){
                return hasPieces;
            }else{
                int[] hasPiece=new int[]{frontNew.getX(),frontNew.getY()};
                hasPieces.add(hasPiece);
            }
        }
        hasPieces=checkRightBehind(frontNew,++count,hasPieces,color);
        return hasPieces;
    }

    //右侧递归检查
    public static List<int[]> checkRight(Chess chess, int count, List<int[]> hasPieces, String color){
        Chess frontNew= chess.getRight();
        if(frontNew==null){
            return hasPieces;
        }
        if(frontNew.getColorType().equals(color)){
            if(count == 0){
                return hasPieces;
            }else{
                int[] hasPiece=new int[]{frontNew.getX(),frontNew.getY()};
                hasPieces.add(hasPiece);
            }
        }
        hasPieces=checkRight(frontNew,++count,hasPieces,color);
        return hasPieces;
    }

    //右上方递归检查
    public static List<int[]> checkRightFront(Chess chess, int count, List<int[]> hasPieces, String color){
        Chess frontNew= chess.getRightfront();
        if(frontNew==null){
            return hasPieces;
        }
        if(frontNew.getColorType().equals(color)){
            if(count == 0){
                return hasPieces;
            }else{
                int[] hasPiece=new int[]{frontNew.getX(),frontNew.getY()};
                hasPieces.add(hasPiece);
            }
        }
        hasPieces=checkRightFront(frontNew,++count,hasPieces,color);
        return hasPieces;
    }
}
