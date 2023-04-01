import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import LoginPage from './components/pages/LoginPage';


function App() {
  return (
    <div className="App" style={{height:"100%"}}>
        <LoginPage class="login" idText="ID:" pwText="PW:"></LoginPage>
    </div>
  );
}

export default App;
