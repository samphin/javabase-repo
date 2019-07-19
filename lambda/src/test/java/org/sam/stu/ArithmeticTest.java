package org.sam.stu;

import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

import java.util.*;

/**
 * 算法练习
 */
public class ArithmeticTest {

    /**
     * 将指定字符串反转（方法一）
     */
    @Test
    public void test() {
        String str = "abcde,efg";
        StringBuffer sb = new StringBuffer();
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        System.out.println("sb = " + sb);
    }

    /**
     * 将指定字符串反转（方法二）
     */
    @Test
    public void test1() {
        String str = "abcde,efg";
        StringBuffer sb = new StringBuffer(str);
        System.out.println("sb.reverse() = " + sb.reverse());
    }

    /**
     * 求字符在指定字符数组中的下标
     */
    @Test
    public void test2() {
        String str = "abcde,efg";
        char[] chars = str.toCharArray();
        int a = Arrays.binarySearch(chars, 'a');
        System.out.println("a = " + a);
    }

    /**
     * 给定一个整形数组和一个整数target，返回2个元素的下标，它们满足相加的和为target。
     * 你可以假定每个输入，都会恰好有一个满足条件的返回结果
     */
    @Test
    public void test3() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int target = 8;
        List<Map<String, Integer>> dataList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Map<String, Integer> collectIndexMap = new HashMap<>();
            //从第一个数字开始算起
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (first + nums[j] == target) {
                    //记录两个数和等于target值的下标
                    collectIndexMap.put("oneIndex", i);
                    collectIndexMap.put("twoIndex", j);
                    dataList.add(collectIndexMap);
                }
            }
        }
        System.out.println("dataList = " + JSONArray.toJSONString(dataList));
    }

    /**
     * 给定一个整形数组和一个整数target，返回2个元素的下标，它们满足相加的和为target。
     * 你可以假定每个输入，都会恰好有一个满足条件的返回结果（方法二）
     */
    @Test
    public void test3_1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int target = 8;
        int[] datas = new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index == null) {
                map.put(nums[i], i);
            } else {
                datas = new int[]{i, index};
            }
        }
        System.out.println("dataList = " + JSONArray.toJSONString(datas));
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
     */
    @Test
    public void test4() {
        //String s = "abcdabcdabcdefghi";
        String s = "abcabcbb";
        char[] chars = s.toCharArray();
        List<String> charList = new ArrayList<>(chars.length);
        for (int i = 0; i < chars.length-1; i++) {
            String subString = "";
            //根据循环因子取出当前字符串的单个字符
            String first = String.valueOf(chars[i]);
            for (int j = i+1; j < chars.length; j++) {
                //从字符数组中取出字符元素与first进行比对
                String two = String.valueOf(chars[j]);
                //一旦发现有相同立即跳出进行下次查找
                if (first.equals(two)) {
                    break;
                } else {
                    if(!subString.contains(two)){
                        subString += two;
                    }
                }
            }
            charList.add(first + subString);
        }
        //汇总已存在的字符的长度（可以得出所有可能性的子字符串）
        List<Map<String, Object>> existCharLengthList = new ArrayList<>();
        charList.forEach(c -> {
            if (s.contains(c)) {
                Map<String, Object> map = new HashMap<>();
                map.put("subString", c);
                map.put("length", c.length());
                existCharLengthList.add(map);
            }
        });

        existCharLengthList.forEach(result->{
            System.out.println("最长字符串 = " + result.get("subString") + "，长度 = "+result.get("length"));
        });

        //根据length倒序
        existCharLengthList.sort((map1, map2) -> (int) map2.get("length") - (int) map1.get("length"));
        Map<String,Object> result = existCharLengthList.get(0);
        //取出不重复字符串长度
        System.out.println("最长字符串 = " + result.get("subString") + "，长度 = "+result.get("length"));

        //取出不重复字符串长度 JDK 求最大长度方式
        /*Optional<Map<String, Object>> max = existCharLengthList.stream().max((map1, map2) -> (int) map1.get("length") - (int) map2.get("length"));
        max.ifPresent(map->{
            System.out.println("最长字符串 = " + map.get("subString") + "，长度 = "+map.get("length"));
        });*/
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的连续的 最长子串 的长度
     */
    @Test
    public void test5() {
        String s = "abcabcbb";
        char[] chars = s.toCharArray();
        List<String> charList = new ArrayList<>(chars.length);
        for (int i = 0; i < chars.length-1; i++) {
            String subString = "";
            //根据循环因子取出当前字符串的单个字符
            String first = String.valueOf(chars[i]);
            for (int j = i+1; j < chars.length; j++) {
                //从字符数组中取出字符元素与first进行比对
                String two = String.valueOf(chars[j]);
                //一旦发现有相同立即跳出进行下次查找
                if (first.equals(two)) {
                    break;
                } else {
                    subString += two;
                }
            }
            charList.add(first + subString);
        }
        //汇总已存在的字符的长度（可以得出所有可能性的子字符串）
        List<Integer> existCharLengthList = new ArrayList<>();
        charList.forEach(c -> {
            if (s.contains(c)) {
                existCharLengthList.add(c.length());
            }
        });

        existCharLengthList.forEach(e->{
            System.out.println("e = " + e);
        });



        /*existCharLengthList.sort((n1,n2)->n2.compareTo(n1));

        System.out.println("maxLength = " + existCharLengthList.get(0));

        return existCharLengthList.get(0);*/

        //求出最大length
        /*Optional<Integer> maxOptional = existCharLengthList.stream().max(Comparator.comparingInt(Integer::valueOf));

        return maxOptional.get();*/
    }



    /**
     * 计算字符串中是否包含值
     */
    @Test
    public void test6() {
        String s = "abcabcbb";
        System.out.println("s = " + s.contains("abc"));
    }
    
}
