package array;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return true;
		}

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start != b.start ? a.end - b.end : a.start - b.start;
			}
		});

		Interval start = intervals[0];
		int i = 1;
		while (i < intervals.length) {
			if (start.end > intervals[i].start) {
				return false;
			} else {
				start = intervals[i];
			}
			i++;
		}

		return true;

	}

	private class Interval {
		int start;
		int end;

		@SuppressWarnings("unused")
		Interval() {
			start = 0;
			end = 0;
		}

		@SuppressWarnings("unused")
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}
