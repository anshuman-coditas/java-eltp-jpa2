package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ak");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Teacher> criteriaQuery=criteriaBuilder.createQuery(Teacher.class);
        Root<Teacher> teacherRoot= criteriaQuery.from(Teacher.class);
        criteriaQuery.orderBy(criteriaBuilder.desc(teacherRoot.get("salary")));
        CriteriaQuery<Teacher> select=criteriaQuery.select(teacherRoot);
        TypedQuery<Teacher> q = entityManager.createQuery(select);
        List<Teacher> list=q.getResultList();
        for(Teacher t:list){
            System.out.println(t);
        }
    }

}
