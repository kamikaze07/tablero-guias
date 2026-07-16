FROM php:8.3-fpm

RUN apt-get update && apt-get install -y --no-install-recommends unzip git \
    && rm -rf /var/lib/apt/lists/*

RUN docker-php-ext-install pdo_mysql

COPY --from=composer:2 /usr/bin/composer /usr/bin/composer
COPY php/timezone.ini /usr/local/etc/php/conf.d/timezone.ini

WORKDIR /var/www/html
