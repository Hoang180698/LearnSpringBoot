import React from 'react';
import classNames from 'classnames/bind';
import styles from './Page.module.scss';
import Content from '../Content';
import Container from '../Container';
import { useParams } from 'react-router-dom';

const cx = classNames.bind(styles);

function Page() {
    const { category } = useParams();
    console.log('category', category);
    return (
        <main className={cx('main')}>
            <header className={cx('page-header')}>
                <h1>{category}</h1>
            </header>
            <Container className={cx('container')}>
                <Content className={cx('content')}></Content>
            </Container>
        </main>
    );
}

export default Page;
