package com.example.repositories;

import com.example.SessionFactoryUtil;
import com.example.models.Reader;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ReaderRepository {
    private final SessionFactory factory = SessionFactoryUtil.getSessionFactory();

    public List<Reader> findAll() {
        Transaction transaction = null;
        List<Reader> readers = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            readers = session.createQuery("from Reader", Reader.class).getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
        return readers;
    }

    public void save(Reader reader) {
        Transaction transaction = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(reader);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    public void update(Reader reader) {
        Transaction transaction = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(reader);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    public Reader findById(Long id) {
        Transaction transaction = null;
        Reader reader = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            reader = session.get(Reader.class, id);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
        return reader;
    }

    public void deleteById(Long id) {
        Transaction transaction = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            Reader reader = session.get(Reader.class, id);
            session.remove(reader);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }
}
