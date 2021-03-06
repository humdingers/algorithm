package com.unisound.algorithm;

//836. 矩形重叠
/*
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。

    如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
    
    给出两个矩形，判断它们是否重叠并返回结果。
    
     
    
    示例 1：
    
    输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
    输出：true
    示例 2：
    
    输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
    输出：false

 */

/*
 * 如果我们在平面中放置一个固定的矩形 rec2，那么矩形 rec1 必须要出现在 rec2 的「四周」，也就是说，矩形 rec1 需要满足以下四种情况中的至少一种：

    矩形 rec1 在矩形 rec2 的左侧；
    
    矩形 rec1 在矩形 rec2 的右侧；
    
    矩形 rec1 在矩形 rec2 的上方；
    
    矩形 rec1 在矩形 rec2 的下方。

 */

/*
 * 果两个矩形重叠，那么它们重叠的区域一定也是一个矩形，那么这代表了两个矩形与 x轴平行的边（水平边）
 * 投影到 x 轴上时会有交集，与 y 轴平行的边（竖直边）投影到 y 轴上时也会有交集。因此，我们可以将问题看作一维线段是否有交集的问题。

算法

矩形 rec1 和 rec2 的水平边投影到 xx 轴上的线段分别为 (rec1[0], rec1[2]) 和 (rec2[0], rec2[2])。根据数学知识我们可以知道，当 min(rec1[2], rec2[2]) > max(rec1[0], rec2[0]) 时，这两条线段有交集。对于矩形 rec1 和 rec2 的竖直边投影到 yy 轴上的线段，同理可以得到，当 min(rec1[3], rec2[3]) > max(rec1[1], rec2[1]) 时，这两条线段有交集

 */
public class IsRectangleOverlap
{
    public boolean isRectangleOverlap(int[] rec1, int[] rec2)
    {
        return !(rec1[2] <= rec2[0] || rec1[0] >= rec2[2] || rec1[3] <= rec2[1] || rec1[1] >= rec2[3]);

    }

    public boolean isRectangleOverlap1(int[] rec1, int[] rec2)
    {

        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])
            && Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));

    }

}
