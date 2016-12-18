package com.moli.blog.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moli.core.util.BeanUtils;
import com.moli.blog.model.BlogInfoBo;
import com.moli.blog.model.CommentsBo;
import com.moli.blog.service.IBlogService;
@Service("blogservice")
public class BlogServiceImpl implements IBlogService {
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Override
	public Long addBlog(final BlogInfoBo blogInfoBo) {
		BeanUtils.notNull(blogInfoBo);
		KeyHolder keyHoder = new GeneratedKeyHolder();
        int affectRow = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("insert into bloginfo(userid,title,subtile,author,posttime,updatetime,content,tags,stars,commentsnu,isdelete) values(?,?,?,?,?,?,?,?,?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);
                int i = 1;
                ps.setLong(i++, blogInfoBo.getUserid());
                ps.setString(i++, blogInfoBo.getTitle());
                ps.setString(i++, blogInfoBo.getSubtile());
                ps.setString(i++, blogInfoBo.getAuthor());
                java.sql.Date posttime = new java.sql.Date(blogInfoBo.getPosttime().getTime());
                ps.setDate(i++, posttime);
                java.sql.Date updatetime = new java.sql.Date(blogInfoBo.getUpdatetime().getTime());
                ps.setDate(i++, updatetime);
                ps.setString(i++, blogInfoBo.getContent());
                ps.setString(i++, blogInfoBo.getTags());
                ps.setInt(i++, blogInfoBo.getStars());
                ps.setInt(i++, blogInfoBo.getCommentsnu());
                ps.setInt(i++, blogInfoBo.getIsdelete());
                return ps;
            }
        }, keyHoder);
        if (affectRow > 0) {
        	blogInfoBo.setId(keyHoder.getKey().longValue());
        } else {
            throw new RuntimeException("新增博客失败");
        }
		return blogInfoBo.getId();
	}

	@Override
	public Integer updateBlog(final BlogInfoBo blogInfoBo) {
		BeanUtils.notNull(blogInfoBo);
		KeyHolder keyHoder = new GeneratedKeyHolder();
        int affectRow = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("UPDATE bloginfo set title=?,subtile=?,author=?,posttime=?,content=?,tags=? WHERE id=?",
                        Statement.RETURN_GENERATED_KEYS);
                int i = 1;
                ps.setString(i++, blogInfoBo.getTitle());
                ps.setString(i++, blogInfoBo.getSubtile());
                java.sql.Date updatetime = new java.sql.Date(blogInfoBo.getUpdatetime().getTime());
                ps.setDate(i++, updatetime);
                ps.setString(i++, blogInfoBo.getContent());
                ps.setString(i++, blogInfoBo.getTags());
                ps.setLong(i++, blogInfoBo.getId());
                return ps;
            }
        }, keyHoder);
        if (affectRow > 0) {
        	blogInfoBo.setId(keyHoder.getKey().longValue());
        } else {
            throw new RuntimeException("新增博客失败");
        }
		return affectRow;
	}

	@Override
	public Integer deleteBlog(final Long id) {
		BeanUtils.notNull(id);
		KeyHolder keyHoder = new GeneratedKeyHolder();
        int affectRow = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("UPDATE bloginfo SET isdelete=1 WHERE id=?",
                        Statement.RETURN_GENERATED_KEYS);
                int i = 1;
                ps.setLong(i++, id);
                return ps;
            }
        }, keyHoder);
        if (affectRow > 0) {
        	return affectRow;
        } else {
            throw new RuntimeException("删除博客失败");
        }
	}

	@Override
	public BlogInfoBo showBlog(Long id) {
		BeanUtils.notNull(id);
		return null;
	}

	@Override
	public List<BlogInfoBo> listBlog(BlogInfoBo blogInfoBo) {
		return null;
	}

	@Override
	@Transactional
	public int addComment(final CommentsBo comment) {
		final String sql = "insert comments(blogid,comid,comname,comtime,comments,modifytime,isdelete) values (?,?,?,?,?,?,?)";
		BeanUtils.notNull(comment);
		KeyHolder keyHoder = new GeneratedKeyHolder();
        int affectRow = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
                int i = 1;
                ps.setLong(i++, comment.getBlogid());
                ps.setLong(i++, comment.getComid());
                ps.setString(i++, comment.getComname());
                java.sql.Date d1 = new java.sql.Date(comment.getComtime().getTime());
                ps.setDate(i++, d1);
                ps.setString(i++, comment.getComments());
                java.sql.Date updatetime = new java.sql.Date(comment.getModifytime().getTime());
                ps.setDate(i++, updatetime);
                ps.setInt(i++, comment.getIsdelete());
                return ps;
            }
        }, keyHoder);
        if(affectRow<=0){
        	throw new RuntimeException();
        }
        String upSql = "update bloginfo set commentsnu=commentsnu+1 where id=?";
        affectRow = jdbcTemplate.update(upSql, comment.getBlogid());
        if(affectRow<=0){
        	throw new RuntimeException();
        }
		return 1;
	}

}
