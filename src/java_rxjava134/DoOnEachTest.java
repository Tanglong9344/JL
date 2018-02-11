package java_rxjava134;

import static java_rxjava134.Commons.debug;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import rx.Observable;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Observable doOnEach
 *
 * @author ÌÆÁú
 *
 */
public class DoOnEachTest {
	public static void main(String[] args) {
		// doOnEach-1
		testDoOnEach1();
		// doOnEach-2
		testDoOnEach2();
		// doOnEach-3
		testDoOnEach3();
		// scheduler
		schedule(null, 0, false);
	}

	/** test1 for 'doOnEach' */
	private static void testDoOnEach1() {
		Observable
		.range(5, 3) // Generate '5' numbers starting with '3'
		.doOnEach(debug("Test")) // 'doOnEach()' receives all the notifications emitted
		.subscribe();
	}

	/** test2 for 'doOnEach' + interval */
	private static void testDoOnEach2() {
		Observable
		.just(1, 2, 3, 4, 5)
		.take(3);
		Observable
		.interval(300L, TimeUnit.MILLISECONDS)
		.doOnEach(debug("Default interval"))
		.subscribe();

		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** test3 for 'doOnEach' + interval + Schedulers*/
	private static void testDoOnEach3() {
		Observable
		.just(1, 2, 3, 4, 5)
		.take(3);
		Observable
		.interval(300L, TimeUnit.MILLISECONDS, Schedulers.immediate())
		.doOnEach(debug("Schedulers"))
		.subscribe();

		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** test for scheduler */
	private static void schedule(Scheduler scheduler, int numberOfSubTasks, boolean onTheSameWorker) {
		List<Integer> list = new ArrayList<>(0);
		AtomicInteger current = new AtomicInteger(0);
		Random random = new Random();
		Worker worker = scheduler.createWorker();
		Action0 addWork = () -> {
			synchronized (current) {
				System.out.println(" Add : " +
						Thread.currentThread().getName() + " " + current.get());
				list.add(random.nextInt(current.get()));
				System.out.println(" End add : " +
						Thread.currentThread().getName() + " " + current.get());
			}
		};
		Action0 removeWork = () -> {
			synchronized (current) {
				if (!list.isEmpty()) {
					System.out.println(" Remove : " + Thread.currentThread().getName());
					list.remove(0);
					System.out.println(" End remove : " + Thread.currentThread().getName());
				}
			}
		};
		Action0 work = () -> {
			System.out.println(Thread.currentThread().getName());
			for (int i = 1; i <= numberOfSubTasks; i++) {
				current.set(i);
				System.out.println("Begin add!");
				if (onTheSameWorker) {
					worker.schedule(addWork);
				} else {
					scheduler.createWorker().schedule(addWork);
				}
				System.out.println("End add!");
			}
			while (!list.isEmpty()) {
				System.out.println("Begin remove!");
				if (onTheSameWorker) {
					worker.schedule(removeWork);
				} else {
					scheduler.createWorker().schedule(removeWork);
				}
				System.out.println("End remove!");
			}
		};
		worker.schedule(work);
	}
}