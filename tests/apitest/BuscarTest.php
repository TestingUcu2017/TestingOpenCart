<?php


namespace tests\ApiTest;

use ApiTester;
use Codeception\Util\HttpCode;

class CrearCest {

    public function _before(ApiTester $I) {
        
    }

    public function _after(ApiTester $I) {
        
    }

    // tests
    public function tryToTest(ApiTester $I) {
        $I->wantTo('Validar busqueda');
        $I->sendGET('http://localhost/opencart-master/upload/index.php?route=product/search&search=iphone');
        $I->seeResponseCodeIs(HttpCode::OK); // 200
        $I->seeResponseIsJson();
        $I->seeResponseContains('<div class="image">');
    }

}

