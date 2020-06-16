package com.lugew.winsim.mapper;

import com.newsense.reviewonline.entity.MeetingUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * @author LuGew
 * @since 2020/5/31
 */
@Mapper
public interface MeetingUserMapper extends MySqlMapper<MeetingUser> {
    @SelectProvider(type = Provider.class, method = "getList")
    List<MeetingUser> getList(MeetingUser entity);

    class Provider {
        public String getList(MeetingUser entity) {
            return new SQL() {{
                SELECT("mu.*,su.user_name as userName");
                FROM("meeting_user mu");
                LEFT_OUTER_JOIN("sys_user su on mu.user_id = su.user_id");
                WHERE("mu.deleted is null or mu.deleted != 1");
                if (null != entity.getMeetingId()) {
                    AND();
                    WHERE("mu.meeting_id=#{meetingId}");
                }
            }}.toString();
        }
    }
}
