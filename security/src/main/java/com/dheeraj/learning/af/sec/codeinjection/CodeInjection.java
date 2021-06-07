package com.dheeraj.learning.af.sec.codeinjection;

/**
 * When a user input is used as input parameter to a java code without sanitizing it,
 * there are chances of code injection.
 * Eg. Class.forName(String classname), this method takes a class name as input.
 * If the class name is taken as user input, if the user gives some arbitrary class name,
 * (like FileInputStream, etc), which would lead to overwrite files in app.
 * To prevent it, we've to use ReflectUtil.checkPackageAccess(classname) method.
 */
public class CodeInjection {
    public static void main(String[] args) {
        CodeInjection obj = new CodeInjection();
        obj.testCodeInjection();
    }

    public void testCodeInjection() {
        try {
            Class.forName("File");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
