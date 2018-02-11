package java_rxjava134;

import static java_rxjava134.Commons.cutOffLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Observable scheduler type
 * 1. immediate
 * 2. trampoline
 * 3. newThread
 * 4. computation
 *
 * @author ÌÆÁú
 *
 */
public class ObservableScheduler {
	public static void main(String[] args) {
		// scheduler.immediate
		System.out.println("--------scheduler.immediate---------");
		schedule(Schedulers.immediate(), 2, true);
		cutOffLine();
		schedule(Schedulers.immediate(), 2, false);
		// scheduler.trampoline
		// it will first execute the entire main action and after that, the sub-tasks
		System.out.println("--------scheduler.trampoline---------");
		schedule(Schedulers.trampoline(), 2, true);
		cutOffLine();
		schedule(Schedulers.trampoline(), 2, false);
		// scheduler.newThread
		// It will have the same behavior as the trampoline but it will run in a new thread
		System.out.println("--------scheduler.newThread---------");
		schedule(Schedulers.newThread(), 2, true);
		cutOffLine();
		schedule(Schedulers.newThread(), 2, false);
		// scheduler.computation
		// The computation scheduler is very similar to the new thread one,
		// but it takes into account the number of processors/cores that
		// the machine on which it runs has, and uses a thread pool that
		// can reuse a limited number of threads

		// The computation Scheduler instance is your real choice for doing
		// background work¡ªcomputations or processing thus its name.
		// You can use it for everything that should run in the background
		// and is not an IO related or blocking operation.
		System.out.println("--------scheduler.computation---------");
		schedule(Schedulers.computation(), 2, true);
		cutOffLine();
		schedule(Schedulers.computation(), 2, false);
		// scheduler.io
		// The Input-Output (IO) scheduler uses a ScheduledExecutorService instance
		// to retrieve the threads from a thread pool for its workers. Unused threads
		// are cached and reused on demand. It can spawn an arbitrary number of
		// threads if it is necessary.
		System.out.println("--------scheduler.io---------");
		schedule(Schedulers.io(), 2, true);
		cutOffLine();
		schedule(Schedulers.io(), 2, false);
	}

	/** test for scheduler */
	private static void schedule(Scheduler scheduler, int numberOfSubTasks, boolean onTheSameWorker) {
		List<Integer> list = new ArrayList<Integer>(0);
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

		// sleep 1s
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}