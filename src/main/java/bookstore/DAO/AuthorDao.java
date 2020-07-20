package bookstore.DAO;

import bookstore.domain.Author;
import bookstore.utils.HybernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthorDao {
    private Transaction transaction = null;

    public void addAuthor(Author author) {
        try {
            Session session = HybernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
            session.close();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }
    public Author getAuthor(Integer id) {
        try {
            Session session = HybernateUtils.getSessionFactory().openSession();
            Author person = session.find(Author.class, id);
            session.close();
            return person;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void removeAuthor(Author author) {
        try {
            Session session = HybernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(author);
            transaction.commit();
            session.close();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }

    }

    public void updateAuthor(Author author) {
        Transaction transaction = null;
        try {
            Session session = HybernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(author);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}
