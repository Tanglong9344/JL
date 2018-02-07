package java_rxjava134;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.observables.ConnectableObservable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**
 * publish() & replay() & share() & subject in Observable
 *
 * @author ÌÆÁú
 *
 */
public class ObservableUnsubcribe {
	public static void main(String[] args) {
		Observable<Long> interval = Observable.interval(100L, TimeUnit.MILLISECONDS);
		// publish
		testPublish(interval);
		// replay
		testReply(interval);
		// share
		testShare(interval);
		// subject
		testSubject(interval);
	}

	/** test publish
	 *
	 * The <code>ConnectableObservable</code> instance can
	 * be created from any <code>Observable</code> instance
	 * by calling its publish() method. In other words, the
	 * publish() method can turn any cold Observable into a hot one
	 * */
	private static <T> void testPublish(Observable<T> observable) {
		ConnectableObservable<T> published = observable.publish(); // publish
		Subscription sub1 = subscribePrint(published, "PublishFirst");
		Subscription sub2 = subscribePrint(published, "PublishSecond");
		published.connect();
		Subscription sub3 = null;
		try {
			Thread.sleep(300L);
			sub3 = subscribePrint(published, "PublishThird");
			Thread.sleep(500L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sub1.unsubscribe();
		sub2.unsubscribe();
		sub3.unsubscribe();
	}

	/** test replay
	 *
	 * Receive all the notifications that have been emitted
	 * before our subscription and then to continue receiving
	 * the incoming ones
	 *
	 * The ConnectableObservable<code></code> created using <method>replay</method>
	 * : all the subscribers, whenever they subscribe, will receive all the
	 * notifications (the previous notifications will arrive in order and synchronously)
	 * */
	private static <T> void testReply(Observable<T> observable) {
		ConnectableObservable<T> published = observable.replay(); // replay
		Subscription sub1 = subscribePrint(published, "ReplyFirst");
		Subscription sub2 = subscribePrint(published, "ReplySecond");
		published.connect();
		Subscription sub3 = null;
		try {
			Thread.sleep(300L);
			sub3 = subscribePrint(published, "ReplyThird");
			Thread.sleep(500L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sub1.unsubscribe();
		sub2.unsubscribe();
		sub3.unsubscribe();
	}

	/** test share */
	private static <T> void testShare(Observable<T> observable) {
		// Observable<T> published = observable.publish().refCount(); // refCount
		// '.share()' is an alias for '.publish().refCount()'
		Observable<T> published = observable.share(); // share
		Subscription sub1 = subscribePrint(published, "RefCountFirst");
		Subscription sub2 = subscribePrint(published, "RefCountSecond");

		try {
			Thread.sleep(300L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// The Observable instance will be deactivated when unsubscribe() is called
		sub1.unsubscribe();
		sub2.unsubscribe();
		Subscription sub3 = subscribePrint(published, "RefCountThird");
		try {
			Thread.sleep(300L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sub3.unsubscribe();
	}

	/** subscribe to a subject
	 *
	 * Four types of subject
	 * 1. PublishSubject(like ConnectedObervable created by publish)
	 * 2. ReplaySubject (like ConnectedObervable created by replay)
	 * 3. BehaviorSubject
	 * 4. AsyncSubject
	 * */
	private static <T> void testSubject(Observable<T> observable) {
		Subject<T, T> publishSubject = PublishSubject.create();
		observable.subscribe(publishSubject);
		Subscription sub1 = subscribePrint(publishSubject, "PublishSubjectFirst");
		Subscription sub2 = subscribePrint(publishSubject, "PublishSubjectSecond");
		Subscription sub3 = null;
		try {
			Thread.sleep(300L);
			sub3 = subscribePrint(publishSubject, "PublishSubjectThird");
			Thread.sleep(500L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sub1.unsubscribe();
		sub2.unsubscribe();
		sub3.unsubscribe();
	}

	/** subscribe an Observable object with a label 'name'
	 * @return */
	public static <T> Subscription subscribePrint(Observable<T> observable, String name) {
		return observable.subscribe(
				(v) -> System.out.println("'" + name + "' : " + v), // OnNext
				(e) -> System.err.println("Error from '" + name + "':" + e.getMessage()), // OnError
				()  -> System.out.println("'" + name + "' ended!") // OnCompleted
				);
	}
}