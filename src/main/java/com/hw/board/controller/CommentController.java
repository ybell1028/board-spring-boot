//package com.hw.board.controller;
//
//import com.hw.board.domain.entity.Comment;
//import com.hw.board.domain.entity.Post;
//import com.hw.board.domain.repository.CommentRepository;
//import com.hw.board.domain.repository.PostRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class CommentController {
//    @Autowired
//    PostRepository postRepository;
//
//    @Autowired
//    CommentRepository commentRepository;
//
//    //CORS(Cross-origin resource sharing)
//    //웹 페이지의 제한된 자원을 외부 도메인에서 접근을 허용해주는 매커니즘
//    /* ex) http:domain-a.com 으로부터 전송되는 HTML페이지가
//    src 속성을 통해 http:domain-b.com 을 요청하는 경우가 있음.
//    오늘날에는 많은 웹 페이지들이 CSS 스타일, 이미지, 그리고
//    스크립트와 같은 리소스들을 각각의 출처로부터 읽어옴 */
//
//    @GetMapping("/post/{id}/comment")
//    public List<Comment> getPostComments(@PathVariable Long id){
//        Post post = postRepository.findById(id).get();
//        return commentRepository.findCommentsByPost(post);
//    }
//
//    @PutMapping("/post/{id}/comment")
//    public List<Comment> createComment(@PathVariable Long id, @RequestBody Comment comment){
//        Optional<Post> postItem = postRepository.findById(id);
//        comment.setPost(postItem.get());
//        commentRepository.save(comment);
//        return comment;
//    }
//
//    @PostMapping("/post/{id}/comment/{commentID}")
//    public Comment updateComment(@PathVariable Long id, @PathVariable Long commentID, @RequestBody Comment comment){
//        Optional<Post> postItem = postRepository.findById(id);
//        comment.setPost(postItem.get());
//        Comment newComment = CommentRepository.findBy
//    }
//}
