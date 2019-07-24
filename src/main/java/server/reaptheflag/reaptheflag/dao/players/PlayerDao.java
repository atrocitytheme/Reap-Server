package server.reaptheflag.reaptheflag.dao.players;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import server.reaptheflag.reaptheflag.model.Player;

@Mapper
public interface PlayerDao {
    @Select("SELECT * FROM player WHERE id = #{inputId}")
    Player getPlayreById(@Param("inputId") String id);
    @Insert("INSERT INTO player(id, score, name, password) VALUES(#{id}, #{score}, #{name}, #{password})")
    void insertPlayer(Player player);
}
