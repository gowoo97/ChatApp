import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import LoginPage from './components/pages/LoginPage';


function App() {
  return (
    <div className="App">   
        <LoginPage></LoginPage>
    </div>
  );
}

export default App;
