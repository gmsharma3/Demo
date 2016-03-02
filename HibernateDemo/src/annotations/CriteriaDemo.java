package annotations;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Projections;

public class CriteriaDemo {
private SessionFactory factory;
	
	public static void main(String[] args) {
		CriteriaDemo test = new CriteriaDemo();
		test.start();
	}
	
	public void start() {
		try {
			factory = new AnnotationConfiguration().configure("annotation.hbm.xml").buildSessionFactory();
		} catch(Exception e) {
			e.printStackTrace();
		}
		List<Employee> list = getList();
		/*for(Employee employee : list){
			System.out.println(employee);
		}*/
		testNativeSQL();
	}
	
	public List<Employee> getList() {
		List<Employee> list = null;
		Session session = factory.openSession();
		Criteria criteria =  session.createCriteria(Employee.class);
		/*Criterion sal = Restrictions.eq("salary",30000);
		Criterion firstName = Restrictions.like("lastName","G%");
		LogicalExpression and = Restrictions.or(sal,firstName);
		criteria.add(and);*/
		criteria.setProjection(Projections.sum("salary"));
		List list1 = criteria.list();
		System.out.println(list1);
		//list = criteria.list();
		return list;
	}
	
	public void testNativeSQL() {
		String sql = "select FIRST_NAME, SALARY from EMPLOYEE";
		Session session = factory.openSession();
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List list = query.list();
		for(Object obj : list){
			Map map = (Map) obj;
			System.out.println(map);
		}
	}
}
