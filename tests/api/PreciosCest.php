<?php

namespace tests\api;

use ApiTester;
use Codeception\Example;
use Codeception\Util\HttpCode;
use function json_decode;

class PreciosCest {

    public function _before(ApiTester $I) {
        
    }

    public function _after(ApiTester $I) {
        
    }

    /**
     * @return array
     */
    protected function preciosProvider() {
        $file = file_get_contents(__DIR__ . '/productos.json');
        return json_decode($file, true);
    }

    /**
     * @dataprovider preciosProvider
     */
    public function consultarPrecio(ApiTester $I, Example $precio) {
        $I->wantTo('Consultar precio de: ' . $precio['product_id']);
        $I->sendGET('', ['route' => 'product/product', 'product_id' => $precio['product_id']]);
        $I->seeResponseCodeIs(HttpCode::OK);
        $I->seeResponseContains($precio['precio']);
    }

}
