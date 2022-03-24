package cn.cry.service.imp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

    private static int i;//代码总行数
    private static int j;//文件个数
    private static int k;//空格数

    public static void main(String args[]) throws IOException {
        System.out.println("file Go...");
        // 这里改成你要遍历的目录路径
        recursiveFiles("D:\\Work\\waihu");
        System.out.println("file End.");
        System.out.println("所写文件个数：" + j);
        System.out.println("所写代码总行数：" + i);
        System.out.println("空格数;"+k);
    }

    /**
     * Xiwi
     * 遍历文件/文件夹 - 函数
     * [String]path        文件路径
     */
    private static void recursiveFiles(String path) throws IOException {

        // 创建 File对象
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("文件夹不存在！！！");
            return;
        }
        // 取 文件/文件夹
        File files[] = file.listFiles();

        // 对象为空 直接返回
        if (files == null) {
            System.out.println("文件夹为空！！！");
            return;
        }

        // 目录下文件
        if (files.length == 0) {
            System.out.println(path + "该文件夹下没有文件");
        }

        // 存在文件 遍历 判断
        for (File f : files) {
            // 判断是否为 文件夹
            if (f.isDirectory()) {
                System.out.print("文件夹: ");
                System.out.println(f.getAbsolutePath());
                // 为 文件夹继续遍历
                recursiveFiles(f.getAbsolutePath());
                // 判断是否为 文件
            } else if (f.isFile()) {
                System.out.print("文件: ");
                System.out.println(f.getAbsolutePath());
                String filename = f.getName();
                if (filename.endsWith(".java")) {//判断是否是.java文件
                    System.out.println("文件地址：" + file.getPath());
                    j++;
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
                    String string = null;
                    while ((string = bufferedReader.readLine()) != null) {

                        //进行过滤注释
                        if (string.indexOf("/*") > -1) {
                            continue;
                        } else if (string.indexOf("*") > -1) {
                            continue;
                        } else if (string.indexOf("//") > -1) {
                            continue;
                        } else if (string.trim().matches("^[//s&&[^//n]]*$")){//去空行
                            k++;
                            continue;
                        }else {
                            System.out.println("string=============" + string);
                            i++;//读取行数
                        }
                    }
                }
            } else {
                System.out.print("未知错误文件");
            }
        }
    }
}

