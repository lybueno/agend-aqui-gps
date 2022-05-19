import './styles.css';
import 'bootstrap/js/src/collapse.js';
import { NavLink } from 'react-router-dom';

const Navbar = () => {
    return (
        <nav className="navbar navbar-expand-md navbar-dark bg-primary main-nav">
            <div className='container-fluid'>
                <a href="/" className="nav-logo-text">
                    <h4>Agend Aqui</h4>
                </a>
                <button
                    className='navbar-toggler'
                    type='button'
                    data-bs-toggle='collapse'
                    data-bs-target='#dscatalog-navbar'
                    aria-controls='dscatalog-navbar'
                    aria-expanded='false'
                    aria-label='Toggle navigation'
                >
                    <span className='navbar-toggler-icon'></span>
                </button>
                <div className='collapse navbar-collapse' id='agendAqui-navbar'>
                    <ul className='navbar-nav offset-md-3 main-menu'>
                        <li>
                            <NavLink to="/">HOME</NavLink>
                        </li>
                        <li>
                            <a href="link">AGENDAR</a>
                        </li>
                        <li>
                            <a href="/schedule">AGENDAMENTOS</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    );
};

export default Navbar; 