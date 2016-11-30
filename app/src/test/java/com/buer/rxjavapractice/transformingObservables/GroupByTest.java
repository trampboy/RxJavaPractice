package com.buer.rxjavapractice.transformingObservables;

import org.junit.Test;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.GroupedObservable;

/**
 * Created by YanMingDao on 30/11/2016.
 */

public class GroupByTest {
    @Test
    public void groupByTest() throws Exception {
        Observable.just(1,2,3,4)
                .groupBy((Func1<Integer, Object>) integer -> integer > 2)
                .subscribe(objectIntegerGroupedObservable -> {
                    System.out.println("key:" + objectIntegerGroupedObservable.getKey());
                    objectIntegerGroupedObservable.subscribe(integer -> {
                        System.out.println("integer:" + integer);
                    });
                });
    }

    // TODO: 30/11/2016 用法不对
    @Test
    public void groupByTest2() throws Exception {
        Observable.just(new Person("Jing1", 15), new Person("Jing2", 30), new Person("Chen1", 18), new Person("Chen2", 19))
                .groupBy(new Func1<Person, Boolean>() {
                    @Override
                    public Boolean call(Person person) {
                        return person.age > 20;
                    }
                }, new Func1<Person, Boolean>() {

                    @Override
                    public Boolean call(Person person) {
                        return person.name.startsWith("Jing");
                    }
                })
                .subscribe(new Action1<GroupedObservable<Boolean, Boolean>>() {
                    @Override
                    public void call(GroupedObservable<Boolean, Boolean> booleanBooleanGroupedObservable) {
                        System.out.println("key:" + booleanBooleanGroupedObservable.getKey());
                        booleanBooleanGroupedObservable.subscribe(new Action1<Boolean>() {
                            @Override
                            public void call(Boolean aBoolean) {

                            }
                        });
                    }
                });
        Observable.just(1,2,3,4)
                .groupBy(new Func1<Integer, Object>() {

                    @Override
                    public Object call(Integer integer) {
                        return integer > 2;
                    }
                }, new Func1<Integer, Object>() {
                    @Override
                    public Object call(Integer integer) {
                        return integer;
                    }
                })
                .subscribe(objectIntegerGroupedObservable -> {
                    System.out.println("key:" + objectIntegerGroupedObservable.getKey());
                    objectIntegerGroupedObservable.subscribe(integer -> {
                        System.out.println("integer:" + integer);
                    });
                });
    }

    private class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
