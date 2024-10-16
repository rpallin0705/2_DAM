import React from 'react';
import ReactDOM from 'react-dom';

const app = () => {
    return (
        <div>
            <h1>Hola Mundo desde React con Babel!</h1>
        </div>
    );
};

ReactDOM.createRoot(<App />, document.getElementById('root'));