import logo from './logo.svg';
import './App.css';
import Game from './Game.jsx';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h1>Welcome to My Game</h1>
      </header>
      <main>
        <Game />
      </main>
      <footer>
        <p>© 2024 Your Game Name</p>
      </footer>
    </div>
  );
}

export default App;
