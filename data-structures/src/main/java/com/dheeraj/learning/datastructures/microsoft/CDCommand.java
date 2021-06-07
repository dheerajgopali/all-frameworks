package com.dheeraj.learning.datastructures.microsoft;

/**
 * Questions asked in Microsoft
 * 	1. Given two numbers A, B, find the numbers of 1 bits in A*B in its binary form.
 * 		a. Eg. A=3, B=7, A*B=21, Binary form = 10101. So number of 1's is 3.
 * 	2. Implement cd command in code.
 * 		a. Given method generatePath(String currentDirectory, String command)
 * 		b. Output has to be the appropriate string. Not related to system directory. Only manipulations on currentDirectory string.
 * 		c. Examples
 * 			i. Eg generatePath("/dev/task", "cd java") --> "/dev/task/java"
 * 			ii. Eg generatePath("/dev/task", "cd /") --> "/"
 * 			iii. Eg generatePath("/dev/task", "cd ..") --> "/dev"
 * 			iv. Eg generatePath("/dev/task", "cd ../..") --> "/"
 *           v. Eg generatePath("/dev/task", "cd ../java") --> "/dev/java"
 */
public class CDCommand {
    public static void main(String[] argS) {
        CDCommand obj = new CDCommand();
        System.out.println(obj.generateCommand("/dev/task","cd java/"));
        System.out.println(obj.generateCommand("/dev/task","cd .."));
        System.out.println(obj.generateCommand("/dev/task","cd ../java"));
        System.out.println(obj.generateCommand("/dev/task","cd ./java"));
        System.out.println(obj.generateCommand("/dev/task/java","cd ../.."));
        System.out.println(obj.generateCommand("/dev/task/java","wrong test"));
        System.out.println(obj.generateCommand("/dev/task/java","cd"));
    }

    public String generateCommand(String currentDirectory, String command) {
        String[] commandArgs = command.split(" ");
        if(commandArgs.length < 2 || !"cd".equalsIgnoreCase(commandArgs[0])) {
            throw new IllegalStateException("Invalid command");
        }

        String dirRegex = commandArgs[1];
        if("/".equals(dirRegex)) {
            return "/";
        }

        String[] dirs = dirRegex.split("/");
        for(String dir: dirs) {
            if(".".equals(dir)) {
                continue;
            } else if("..".equals(dir)) {
                currentDirectory = currentDirectory.substring(0, currentDirectory.lastIndexOf("/"));
            } else if(!"".equals(dir)) {
                currentDirectory += "/" + dir;
            }
        }

        return currentDirectory;
    }
}
