import { ReactComponent as GithubIcon } from 'assets/img/github.svg';
import 'assets/css/styles.css';

function NavBar() {
    return (

        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <h1>GTvendas</h1>
                    <a href="https://github.com/Geovane404" target="_blank" rel="noreferrer" >
                        <div className="dsmovie-contact-container">
                            <GithubIcon />
                            <p className="dsmovie-contact-link"></p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>

    );

}

export default NavBar;
