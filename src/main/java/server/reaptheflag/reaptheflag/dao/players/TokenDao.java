package server.reaptheflag.reaptheflag.dao.players;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import server.reaptheflag.reaptheflag.model.Token;

@Mapper
public interface TokenDao {
    @Select("SELECT * FROM Token WHERE id={selectedAdmin}")
    public Token getTokenById(@Param("selectedAdmin") String adminId);
}
