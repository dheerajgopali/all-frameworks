package com.dheeraj.learning.af.lamda;

import java.util.*;

public class MapsUsage {
    static Map<SamplePojo, Integer> map = new HashMap<SamplePojo, Integer>();
    public static void main(String[] args) {
        MapsUsage mu = new MapsUsage();
        mu.test();
    }

    public void test() {
        map.put(new SamplePojo("a","f"),10);
        map.put(new SamplePojo("b","g"),20);
        map.put(new SamplePojo("c","h"),30);
        map.put(new SamplePojo("d","i"),40);
        map.put(new SamplePojo("e","j"),50);

        System.out.println(map);
        /*map.entrySet().stream()
                .filter(entry -> (entry.getKey().getJob().equalsIgnoreCase("f") ||
                        entry.getKey().getName().equalsIgnoreCase("c")))
                .forEach(entry -> remove(entry.getKey()));*/
        /*map.forEach((key, value) -> remove(key));*/
        /*Iterator<SamplePojo> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            SamplePojo pojo = iter.next();
            if(pojo.getName().equalsIgnoreCase("a") || pojo.getJob().equalsIgnoreCase("i"))
                remove(pojo);
        }*/
        Set<SamplePojo> set =  new HashSet<>(map.keySet());
        set.stream().filter(key -> (key.getName().equalsIgnoreCase("a") || key.getJob().equalsIgnoreCase("g")))
                .forEach(this::remove);
        System.out.println(map);
    }

    public void remove(SamplePojo pojo) {
        map.remove(pojo);
    }
}

class SamplePojo {
    String name;
    String job;

    public SamplePojo(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SamplePojo that = (SamplePojo) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return job != null ? job.equals(that.job) : that.job == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (job != null ? job.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SamplePojo{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}