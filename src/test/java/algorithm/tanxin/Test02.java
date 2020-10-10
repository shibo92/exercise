package algorithm.tanxin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 会议安排问题
 * 问题：从会议中尽可能多的安排会议
 * 思路：取end最小，且与已安排的会议相容的会议安排
 *
 * @author by shibo on 2020/10/10.
 */
public class Test02 {
    @Test
    public void test() {
        List<Meeting> meetings = initMeeting();
        sortByEndTime(meetings);
        meetings.forEach(meeting -> System.out.print("(" + meeting.getIndex() + ")" + "start:" + meeting.getStart() + " end:" + meeting.getEnd() + " "));
        List<Meeting> solveMeetings = solve(meetings);
        System.out.println();
        System.out.println("最终安排的会议:");
        solveMeetings.forEach(meeting -> System.out.println(meeting.getIndex() + " start:" + meeting.getStart() + " end:" + meeting.getEnd()));
    }

    private List<Meeting> solve(List<Meeting> meetings) {
        int lastEndTime = meetings.get(0).getEnd();
        List<Meeting> result = new ArrayList<>();
        result.add(meetings.get(0));
        for (int i = 1; i < meetings.size(); i++) {
            // 如果当前会议的start大于最后一个会议的end，说明相容
            if (meetings.get(i).getStart() > lastEndTime) {
                result.add(meetings.get(i));
                lastEndTime = meetings.get(i).getEnd();
            }
        }
        return result;
    }

    /**
     * 按end升序。end相同，按start降序
     *
     * @param meetings
     */
    private void sortByEndTime(List<Meeting> meetings) {
        meetings.sort((m1, m2) -> {
            if (m1.getEnd().equals(m2.getEnd())) {
                // 按start从大到小排序
                return m2.getStart().compareTo(m1.getStart());
            }
            // 按end从小到大排序
            return m1.getEnd().compareTo(m2.getEnd());
        });
    }

    private List<Meeting> initMeeting() {
        Meeting m1 = new Meeting(1, 3, 6);
        Meeting m2 = new Meeting(2, 1, 4);
        Meeting m3 = new Meeting(3, 5, 7);
        Meeting m4 = new Meeting(4, 2, 5);
        Meeting m5 = new Meeting(5, 5, 9);
        Meeting m6 = new Meeting(6, 3, 8);
        Meeting m7 = new Meeting(7, 8, 11);
        Meeting m8 = new Meeting(8, 6, 10);
        Meeting m9 = new Meeting(9, 8, 12);
        Meeting m10 = new Meeting(10, 12, 14);
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(m1);
        meetings.add(m2);
        meetings.add(m3);
        meetings.add(m4);
        meetings.add(m5);
        meetings.add(m6);
        meetings.add(m7);
        meetings.add(m8);
        meetings.add(m9);
        meetings.add(m10);
        return meetings;
    }
}

class Meeting {
    private Integer index;
    private Integer start;
    private Integer end;

    public Meeting(Integer index, Integer start, Integer end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }

    public Integer getIndex() {
        return index;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }
}
