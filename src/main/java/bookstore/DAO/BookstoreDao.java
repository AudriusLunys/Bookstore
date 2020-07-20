package bookstore.DAO;

import bookstore.domain.Author;
import bookstore.domain.Book;
import bookstore.domain.Bookstore;
import bookstore.utils.HybernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookstoreDao {

    private Transaction transaction = null;

    public void addBookStore(Bookstore bookstore) {
        try {
            Session session = HybernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(bookstore);
            transaction.commit();
            session.close();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }

    public Bookstore getBookStore(Integer id) {
        try {
            Session session = HybernateUtils.getSessionFactory().openSession();
            Bookstore bookstore = session.find(Bookstore.class, id);
            session.close();
            return bookstore;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void removeBookStore(Bookstore bookstore) {
        try {
            Session session = HybernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(bookstore);
            transaction.commit();
            session.close();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }

    public void updateBookStore (Bookstore bookstore) {
        Transaction transaction = null;
        try {
            Session session = HybernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(bookstore);
            transaction.commit();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}