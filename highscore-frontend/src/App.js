import React, { Component } from 'react';
import './App.css';
import PlayersList from './components/PlayersList';

class App extends Component {
  render() {
    return (
      <div className="App container">
        <PlayersList />
      </div>
    );
  }
}

export default App;
