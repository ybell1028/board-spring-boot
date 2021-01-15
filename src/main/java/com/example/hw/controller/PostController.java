package com.example.hw.controller;

import com.example.hw.entity.Post;
import com.example.hw.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*데이터를 반환하는 컨트롤러
view가 필요없는 API에 지원 (Spring4.0.1 이후)*/
@RestController
public class PostController {

    // 먼저 @Autowired 어노테이션을 통해서 스프링부트(스프링 프레임워크)가 자동적으로 postRepository 객체를 자동으로 생성하게 해주었다.
    @Autowired // 해당 인스턴스 변수에 스프링으로부터 자동으로 Bean을 주입, new 연사자와 같음
    PostRepository postRepository;

    @GetMapping("/")
    public String hello(){
        return "Main Page!";
    }

    //RequestMapping(Method=RequestMethod.GET)과 동일
    @GetMapping("/post")
    //List<Post>에서 Post는 엔티티에 있는 포스트를 뜻함
    public List<Post> getAllPost(){
        // getAllPost() 에서는 findAll() 함수를 통해 데이터베이스에서 모든 post를 가져온다.
        return postRepository.findAll();
    }

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable String id){
        // @PathVariable - 메소드 파라미터 앞에 사용하며 해당 URL에 { } 특정 파라미터를 변수로 활용 가능
        Long postID = Long.parseLong(id);

        //getPost() 에서는 findById() 함수를 통해 데이터베이스에서 지정된 id를 가진 post를 가져온다.
        Optional<Post> post = postRepository.findById(postID);

        return post.get();
    }

    // RequestMapping(Method=RequestMethod.POST)과 동일
    @PostMapping("/post/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post newPost){
        // @RequestBody - 요청으로 들어온 데이터(Json, XML)를 클래스나 model로 매핑
        Long postID = Long.parseLong(id);

        Optional<Post> post = postRepository.findById(postID); // 포스트 내용을 파라미터의 id로 찾아 저장

        /* updatePost() 에서는 findById()를 통해 수정할 post를 가져와서
        setter를 이용해서 데이터를 수정하고, 다시 반환하는 방식으로 구현하였다. */
        post.get().setTitle(newPost.getTitle());
        post.get().setContent(newPost.getContent());

        // createPost() 에서는 save() 함수를 통해 json으로 넘겨받은 post를 저장한다.
        postRepository.save(post.get());

        return post.get();
    }

    @PutMapping("/post")
    public Post createPost(@RequestBody Post post){
        Post newPost = postRepository.save(post);

        System.out.println("끼에엑");

        return newPost;
    }

    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable String id){
        Long postID = Long.parseLong(id);
        postRepository.deleteById(postID);

        return "Delete Success!";
    }

    /* @RequestBody Post post 부분을 보면
    어떻게 Post를 저렇게 바로 넘겨받을수 있지? 라고 생각 할수 있지만,
    사실은 내부적으로 스프링의 HTTPMessageConverter에 의해 JSON과,
    객체간의 변환이 수행되어서 저렇게 사용할 수 있는것이다. */
}
