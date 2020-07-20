package bookstore.DAO;


import bookstore.domain.Author;
import bookstore.domain.Book;
import bookstore.utils.HybernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDao {

    private Transaction transaction = null;

    public void addBook(Book book) {
        try {
            Session session = HybernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
            session.close();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }

    public Book getBook (Integer id) {
        try {
            Session session = HybernateUtils.getSessionFactory().openSession();
            Book book = session.find(Book.class, id);
            session.close();
            return book;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void removeBook (Book book) {
        try {
            Session session = HybernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(book);
            transaction.commit();
            session.close();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }

    }
    public void updateBook (Book book) {
        Transaction transaction = null;
        try {
            Session session = HybernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}
