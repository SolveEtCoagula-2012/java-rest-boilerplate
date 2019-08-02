import React from 'react';
import './App.css';

interface AppState {
  clicked: boolean;
}

class App extends React.Component<object, AppState> {
  
  constructor(props: any) {
    super(props);
    this.state = {
      clicked: false,
    }
  }

  public render() {
    const {clicked} = this.state;

    return (
      <div className="App">
        <button onClick={this.onClick}>Click Me!!!</button>
        {clicked ? <div style={{width: '100px', height: '100px', background: 'blue'}}></div> : <div style={{width: '100px', height: '100px', background: 'red'}}></div>}
      </div>
    );
  }

  private onClick = (e: any) => {
    this.setState({clicked: !this.state.clicked})
  }
}

export default App;
