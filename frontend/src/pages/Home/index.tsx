
import Navbar from "../../components/Navbar";
import MainImage from 'assets/images/main-image.jpg'
import './styles.css';
import CardLogin from 'components/CardLogin';

const Home = () => {
    return (
      <>
        <Navbar />
        <div className="home-container">
            <div className="home-card">
                <div className="home-content-container">
                    <CardLogin />
                </div>
                <div className="home-image-container">
                    <img src={MainImage} alt='Logo Barbearia'/>
                </div>
            </div>
        </div>
      </>
    );
  };

  export default Home; 