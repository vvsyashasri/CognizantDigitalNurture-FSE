import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false,
      errorMessage: ""
    };
  }

  // Method to load posts from API
  loadPosts = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        if (!response.ok) throw new Error('Failed to fetch posts');
        return response.json();
      })
      .then(data => {
        this.setState({ posts: data });
      })
      .catch(error => {
        this.setState({ hasError: true, errorMessage: error.message });
      });
  };

  // componentDidMount lifecycle hook
  componentDidMount() {
    this.loadPosts();
  }

  // componentDidCatch lifecycle hook for error handling
  componentDidCatch(error, info) {
    this.setState({ hasError: true, errorMessage: error.toString() });
    alert("An error occurred: " + error.toString());
  }

  render() {
    if (this.state.hasError) {
      return (
        <div style={{ color: 'red', textAlign: 'center', marginTop: '2rem' }}>
          <h2>Error Occurred</h2>
          <p>{this.state.errorMessage}</p>
        </div>
      );
    }

    return (
      <div>
        <h2 style={{textAlign: "center"}}>Blog Posts</h2>
        {this.state.posts.slice(0, 10).map(post => (
          <Post key={post.id} title={post.title} body={post.body} />
        ))}
      </div>
    );
  }
}

export default Posts;