import './App.css';
import Navi from './layouts/Navi/Navi';
import {Container} from 'semantic-ui-react'
import 'semantic-ui-css/semantic.min.css'
import Home from './pages/Home/Home';
import Footer from './layouts/Footer/Footer';
import JobAdvertisements from './pages/JobAdvertisements';
import SignupEmployer from './pages/Signup/SignupEmployer';
import Login from './pages/Login/Login';
import SignupJobSeeker from './pages/Signup/SignupJobSeeker';

function App() {
  return (
    <div className="App">
      <Navi/>
      <Container className="main" >
      {/* <Home></Home> */}
      {/* <Login></Login> */}
      {/* <SignupEmployer></SignupEmployer> */}
      {/* <SignupJobSeeker></SignupJobSeeker> */}
      {/* <JobAdvertisements></JobAdvertisements> */}
      </Container>
      <Footer></Footer>
    </div>
  );
}

export default App;
